import React, { useState, useEffect } from "react";
import Paper from "@mui/material/Paper";
import Button from "@mui/material/Button";
import { Link } from "react-router-dom";
import {
  TableContainer,
  Table,
  TableBody,
  TableRow,
  TableCell,
} from "@mui/material";
import Dialog from "@mui/material/Dialog";
import DialogTitle from "@mui/material/DialogTitle";
import DialogContent from "@mui/material/DialogContent";
import DialogContentText from "@mui/material/DialogContentText";
import DialogActions from "@mui/material/DialogActions";
import CloseIcon from "@mui/icons-material/Close";

export default function Home() {
  const [plans, setPlans] = useState([]);
  const [role, setRole] = useState(null);

  useEffect(() => {
    fetch("http://localhost:8080/")
      .then((res) => res.json())
      .then((result) => {
        setPlans(result);
        const role = localStorage.getItem("role");
        if (role) {
          setRole(role);
        }
      });
  }, []);
  const [showMessage, setShowMessage] = useState("");
  const [open, setOpen] = React.useState(false);

  const handleSubmitSciencePlan = async (planNo) => {
    try {
      const response = await fetch(
        `http://localhost:8080/submitSci/${planNo}`,
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify({ id: planNo }),
        }
      );
      if (response.ok) {
        // Assuming the response returns the updated science plan
        const updatedSciencePlan = await response.json();
        // Show popup alert
        window.alert("SciPlan was submitted");
        // Do something with the updated science plan if needed
        console.log("Science plan submitted:", updatedSciencePlan);
      } else {
        throw new Error("Failed to submit science plan");
      }
    } catch (error) {
      console.error("Error submitting science plan:", error);
      // Handle error
    }
  };

  const handleShowObserving = async (planNo) => {
    try {
      const response = await fetch(`http://localhost:8080/observing/${planNo}`);
      if (response.ok) {
        const observingProgram = await response.json();
        // Display observing program data as dialog
        setShowMessage(JSON.stringify(observingProgram));
        setOpen(true);
      } else {
        throw new Error("Failed to fetch observing program");
      }
    } catch (error) {
      console.error("Error fetching observing program:", error);
      setShowMessage("Failed to fetch observing program");
      setOpen(true);
    }
  };

  const handleValidateObserving = async (planNo) => {
    try {
      const response = await fetch(
        `http://localhost:8080/validateObserving/${planNo}`,
        {
          method: "POST",
        }
      );

      const responseBody = await response.text(); // or response.json() if the response is JSON
      window.alert("Validate Observing success");
      console.log(responseBody);
    } catch (error) {
      console.error("Error Validating observing program:", error);
    }
  };

  const formatObservingProgram = (observingProgram) => {
    let formattedString = "";
    for (const [key, value] of Object.entries(observingProgram)) {
      if (Array.isArray(value)) {
        formattedString += `${key}: \n`;
        value.forEach((item) => {
          formattedString += `\t${JSON.stringify(item)}\n`;
        });
      } else {
        formattedString += `${key}: ${JSON.stringify(value)}\n`;
      }
    }

    return formattedString;
  };

  const handleClose = (event) => {
    setOpen(false);
  };

  return (
    <Paper
      elevation={3}
      sx={{
        display: "flex",
        flexDirection: "column",
        padding: 4,
        margin: 3,
      }}
    >
      {plans.map((plan) => (
        <Paper
          elevation={6}
          key={plan.planNo}
          sx={{
            display: "flex",
            flexDirection: "column",
            m: 2,
          }}
        >
          <TableContainer>
            <Table>
              <TableBody>
                <TableRow>
                  <TableCell>Plan Number</TableCell>
                  <TableCell>{plan.planNo}</TableCell>
                </TableRow>
                <TableRow>
                  <TableCell>Creator</TableCell>
                  <TableCell>{plan.creator}</TableCell>
                </TableRow>
                <TableRow>
                  <TableCell>Submitter</TableCell>
                  <TableCell>{plan.submitter}</TableCell>
                </TableRow>
                <TableRow>
                  <TableCell>Funding</TableCell>
                  <TableCell>{plan.fundingInUSD} USD</TableCell>
                </TableRow>
                <TableRow>
                  <TableCell>Objectives</TableCell>
                  <TableCell>
                    <ul style={{ listStyleType: "none", padding: 0 }}>
                      {plan.objectives.split("\n").map((objective, index) => (
                        <li key={index}>{objective}</li>
                      ))}
                    </ul>
                  </TableCell>
                </TableRow>
                <TableRow>
                  <TableCell>Star System</TableCell>
                  <TableCell>{plan.starSystem}</TableCell>
                </TableRow>
                <TableRow>
                  <TableCell>Start Date</TableCell>
                  <TableCell>{plan.startDate}</TableCell>
                </TableRow>
                <TableRow>
                  <TableCell>End Date</TableCell>
                  <TableCell>{plan.endDate}</TableCell>
                </TableRow>
                <TableRow>
                  <TableCell>Telescope Location</TableCell>
                  <TableCell>{plan.telescopeLocation}</TableCell>
                </TableRow>
                <TableRow>
                  <TableCell>Data Processing Requirements</TableCell>
                  <TableCell>
                    <ul style={{ listStyleType: "none", padding: 0 }}>
                      {plan.dataProcRequirements.map((req, index) => (
                        <li key={index}>
                          File Type: {req.fileType}, File Quality:{" "}
                          {req.fileQuality}, Color Type: {req.colorType},
                          Contrast: {req.contrast}, Brightness: {req.brightness}
                          , Saturation: {req.saturation}, Highlights:{" "}
                          {req.highlights}, Exposure: {req.exposure}, Shadows:{" "}
                          {req.shadows}, Whites: {req.whites}, Blacks:{" "}
                          {req.blacks}, Luminance: {req.luminance}, Hue:{" "}
                          {req.hue}
                        </li>
                      ))}
                    </ul>
                  </TableCell>
                </TableRow>
                <TableRow>
                  <TableCell>Status</TableCell>
                  <TableCell>{plan.status}</TableCell>
                </TableRow>

                {plan.status !== "TESTED" && role === "ScienceObserver" && (
                  <TableRow>
                    <TableCell>Create Observing Program</TableCell>
                    <TableCell>
                      <Button
                        component={Link}
                        to={`/create-observing/${plan.planNo}`}
                        variant="contained"
                      >
                        Create
                      </Button>
                    </TableCell>
                  </TableRow>
                )}

                {role === "Astronomer" && (
                  <TableRow>
                    <TableCell>Submit SciPlan</TableCell>
                    <TableCell>
                      <Button
                        onClick={() => handleSubmitSciencePlan(plan.planNo)}
                        variant="contained"
                      >
                        Submit
                      </Button>
                    </TableCell>
                  </TableRow>
                )}

                <TableRow>
                  <TableCell />
                  <TableCell>
                    <Button
                      onClick={() => handleShowObserving(plan.planNo)}
                      variant="contained"
                    >
                      show observing program
                    </Button>
                  </TableCell>
                </TableRow>

                <Dialog
                  open={open}
                  onClose={handleClose}
                  aria-labelledby="scroll-dialog-title"
                  aria-describedby="scroll-dialog-description"
                >
                  <DialogTitle id="scroll-dialog-title">
                    Observing Program
                  </DialogTitle>
                  <DialogContent>
                    <pre>
                      {showMessage &&
                        formatObservingProgram(JSON.parse(showMessage))}
                    </pre>
                  </DialogContent>
                  <DialogActions>
                    {role === "TelescopeOperator" && (
                      <Button
                        onClick={() =>
                          handleValidateObserving(
                            JSON.parse(showMessage)["planNo"]
                          )
                        }
                        variant="contained"
                      >
                        validate
                      </Button>
                    )}
                    <Button onClick={handleClose}>
                      <CloseIcon />
                    </Button>
                  </DialogActions>
                </Dialog>
              </TableBody>
            </Table>
          </TableContainer>
        </Paper>
      ))}
    </Paper>
  );
}
