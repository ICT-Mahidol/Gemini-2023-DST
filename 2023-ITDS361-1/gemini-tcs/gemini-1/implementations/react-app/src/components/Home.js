import React, { useState, useEffect } from "react";
import Paper from '@mui/material/Paper';
import Button from '@mui/material/Button';
import { Link, } from 'react-router-dom';
import { TableContainer, Table, TableBody, TableRow, TableCell } from '@mui/material';


export default function Home() {
    const [plans, setPlans] = useState([])

    useEffect(() => {
        fetch("http://localhost:8080/")
            .then(res => res.json())
            .then((result) => {
                setPlans(result)
            })
    }, [])

    return (
        <Paper
            elevation={3}
            sx={{
                display: 'flex',
                flexDirection: 'column',
                padding: 4,
                margin: 3
            }}
        >
            {plans.map(plan => (
                <Paper
                    elevation={6}
                    key={plan.planNo}
                    sx={{
                        display: 'flex',
                        flexDirection: 'column',
                        m: 2
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
                                        <ul style={{ listStyleType: 'none', padding: 0 }}>
                                            {plan.objectives.split('\n').map((objective, index) => (
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
                                        <ul style={{ listStyleType: 'none', padding: 0 }}>
                                            {plan.dataProcRequirements.map((req, index) => (
                                                <li key={index}>
                                                    File Type: {req.fileType},
                                                    File Quality: {req.fileQuality},
                                                    Color Type: {req.colorType},
                                                    Contrast: {req.contrast},
                                                    Brightness: {req.brightness},
                                                    Saturation: {req.saturation},
                                                    Highlights: {req.highlights},
                                                    Exposure: {req.exposure},
                                                    Shadows: {req.shadows},
                                                    Whites: {req.whites},
                                                    Blacks: {req.blacks},
                                                    Luminance: {req.luminance},
                                                    Hue: {req.hue}
                                                </li>
                                            ))}
                                        </ul>
                                    </TableCell>
                                </TableRow>
                                <TableRow>
                                    <TableCell>Status</TableCell>
                                    <TableCell>{plan.status}</TableCell>
                                </TableRow>

                                {plan.status === 'TESTED' && (
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

                            </TableBody>
                        </Table>
                    </TableContainer>
                </Paper>
            ))}

        </Paper>
    )
}