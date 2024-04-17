import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import CssBaseline from '@mui/material/CssBaseline';
import InputLabel from '@mui/material/InputLabel';
import Box from '@mui/material/Box';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select from '@mui/material/Select';
import TextField from '@mui/material/TextField';
import Grid from '@mui/material/Grid';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import SendIcon from '@mui/icons-material/Send';
import AddCircleIcon from '@mui/icons-material/AddCircle';
import DeleteOutlineIcon from '@mui/icons-material/DeleteOutline';


export default function CreatingObservingProgram() {
    const [sciencePlan, setSciencePlan] = useState('')
    const {planNo} = useParams();
    const [opticsPrimary, setOpticsPrimary] = useState('');
    const [fStop, setFStop] = useState('');
    const [opticsSecondaryRMS, setOpticsSecondaryRMS] = useState('')
    const [foldMirrorDegree, setFoldMirrorDegree] = useState('');
    const [foldMirrorType, setFoldMirrorType] = useState('');
    const [moduleContent, setModuleContent] = React.useState('');
    const [calibrationUnit, setCalibrationUnit] = React.useState('');
    const [lightType, setLightType] = useState('');
    const [telePositionPairs, setTelePositionPairs] = useState([{ direction: '', degree: '' }]);

    

    const [fStopError, setFStopError] = useState(false);
    const [opticsSecondaryError, setOpticsSecondaryError] = useState(false);
    const [scienceFoldMirrorDegreeError, setScienceFoldMirrorDegreeError] = useState(false);

    useEffect(() => {
        fetch(`http://localhost:8080/${planNo}`)
        .then(res => {
            if (!res.ok) {
                throw new Error('Failed to fetch data');
            }
            return res.json();
        })
        .then((result) => {
            setSciencePlan(result)
        })
    }, [planNo])

    const handleSubmit = (event) => {
        event.preventDefault()
        const observingProgram  = {
            id: planNo,
            opticsPrimary: opticsPrimary, 
            fStop: fStop, 
            opticsSecondaryRMS: opticsSecondaryRMS, 
            scienceFoldMirrorDegree: foldMirrorDegree,
            scienceFoldMirrorType: foldMirrorType, 
            moduleContent: moduleContent,
            calibrationUnit: calibrationUnit,
            lightType: lightType,
            telePositionPair: telePositionPairs
    }
        console.log(observingProgram )
        fetch("http://localhost:8080/observing", {
            method: "POST",
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify(observingProgram)
        }).then(() => {"New Observing Program Added"})
    }


    const handleOpticsPrimaryChange = (event) => {
        setOpticsPrimary(event.target.value);
    };

    const handleFStopChange = (event) => {
        const newValue = event.target.value;
        const minFStop = opticsPrimary === 'GNZ' ? 1.8 : 2.9;
        const maxFStop = opticsPrimary === 'GNZ' ? 8.1 : 18;

        if (isNaN(newValue) || newValue < minFStop || newValue > maxFStop) {
            setFStopError(true);
        } else {
            setFStopError(false);
        }

        setFStop(newValue);
    };

    const handleOpticsSecondaryRMSChange = (event) => {
        const newValue = event.target.value;
        const minOpticsSecondary = 5
        const maxOpticsSecondary = sciencePlan.telescopeLocation === 'CHILE' ? 13 : 17;

        if (isNaN(newValue) || newValue < minOpticsSecondary || newValue > maxOpticsSecondary) {
            setOpticsSecondaryError(true);
        } else {
            setOpticsSecondaryError(false);
        }

        setOpticsSecondaryRMS(newValue);
    }

    const handleFoldMirrorTypeChange = (event) => {
        setFoldMirrorType(event.target.value);
    };

    const handleModuleContentChange = (event) => {
        setModuleContent(event.target.value);
    };

    const handleCalibrationUnitChange = (event) => {
        setCalibrationUnit(event.target.value);
    };

    const handleLightTypeChange = (event) => {
        setLightType(event.target.value);
    };

    const handleScienceFoldMirrorDegreeChange = (event) => {
        const degree = event.target.value;
        setFoldMirrorDegree(degree);
        if (degree < 30 || degree > 45) {
            setScienceFoldMirrorDegreeError(true);
        } else {
            setScienceFoldMirrorDegreeError(false);
        }
    };

    const handleTelePositionPairChange = (index, key, value) => {
        const updatedTelePositionPairs = [...telePositionPairs];
        updatedTelePositionPairs[index][key] = value;
        setTelePositionPairs(updatedTelePositionPairs);
    };

    const addTelePositionPair = () => {
        setTelePositionPairs([...telePositionPairs, { direction: '', degree: '' }]);
    };

    const deleteTelePositionPair = (index) => {
        const updatedTelePositionPairs = [...telePositionPairs];
        updatedTelePositionPairs.splice(index, 1);
        setTelePositionPairs(updatedTelePositionPairs);
    };

    return (
        <Grid component="main" >
            <CssBaseline />
            <Grid container justifyContent="center" spacing={2}
                sx={{ marginTop: 2, marginBottom: 2, textAlign: 'left' }}
            >
                <Grid item xs={12} md={7}>
                    <Box sx={{mb:2}}>
                        <Typography variant='h5'>Plan Number: {planNo}</Typography>
                        <Grid container spacing={2}>
                            <Grid item xs={7}>
                                <FormControl margin='normal' fullWidth >
                                    <InputLabel required id="opticsPrimary">
                                        Primary optics
                                    </InputLabel>
                                    <Select
                                        labelId="opticsPrimary"
                                        id="opticsPrimary"
                                        value={opticsPrimary}
                                        label="Primary optics"
                                        onChange={handleOpticsPrimaryChange}
                                    >
                                        <MenuItem value="">
                                            <em>None</em>
                                        </MenuItem>
                                        <MenuItem value="GNZ">GNZ (GN Zemax Model)</MenuItem>
                                        <MenuItem value="GSZ">GSZ (GS Zemax Model)</MenuItem>
                                    </Select>
                                </FormControl>
                            </Grid>
                            <Grid item xs={5}>
                                <TextField
                                    margin='normal'
                                    id="fStop"
                                    label="f-stop"
                                    type="number"
                                    fullWidth
                                    value={fStop}
                                    onChange={handleFStopChange}
                                    error={fStopError}
                                    inputProps={{
                                        min: opticsPrimary === 'GNZ' ? 1.8 : 2.9,
                                        max: opticsPrimary === 'GNZ' ? 8.1 : 18,
                                        step: 0.1
                                    }}
                                    InputLabelProps={{
                                        shrink: true,
                                    }}
                                    helperText={
                                        opticsPrimary &&
                                        (fStopError
                                            ? "Incorrect entry. Please enter a value within the specified range."
                                            : `The value range of f-stop for ${opticsPrimary} is ${opticsPrimary === "GNZ" ? "1.8 - 8.1" : "2.9 - 18"
                                            }`)
                                    }
                                />
                            </Grid>

                        </Grid>

                        <TextField
                            margin="normal"
                            required
                            fullWidth
                            id="opticsSecondaryRMS"
                            label="Secondary optics"
                            name="opticsSecondaryRMS"
                            type='number'
                            value={opticsSecondaryRMS}
                            onChange={handleOpticsSecondaryRMSChange}
                            error={opticsSecondaryError}
                            inputProps={{
                                min: 5,
                                max: sciencePlan.telescopeLocation === 'CHILE' ? 13 : 17,
                                step: 0.1
                            }}
                            InputLabelProps={{
                                shrink: true,
                            }}
                            helperText={
                                sciencePlan.telescopeLocation &&
                                (opticsSecondaryError
                                    ? "Incorrect entry. Please enter a value within the specified range."
                                    : `The value range of secondary optics for telescope at ${sciencePlan.telescopeLocation} is ${sciencePlan.telescopeLocation === "CHILE" ? "5 - 13 nm" : "5 - 17 nm"
                                    }`)
                            }
                        />
                        <TextField
                            margin="normal"
                            required
                            fullWidth
                            id="scienceFoldMirrorDegree"
                            label="Degree of angle of the fold mirror"
                            name="scienceFoldMirrorDegree"
                            type="number"
                            value={foldMirrorDegree}
                            inputProps={{
                                min: 30,
                                max: 45,
                            }}
                            onChange={handleScienceFoldMirrorDegreeChange}
                            error={scienceFoldMirrorDegreeError}
                            helperText={
                                scienceFoldMirrorDegreeError
                                    ? "The degree must be within the range of 30 to 45."
                                    : "The supported degree is in the range of 30 to 45."
                            }                        
                        />

                        <FormControl margin='normal' fullWidth>
                            <InputLabel required id="scienceFoldMirrorType">
                                Type of the fold mirror
                            </InputLabel>
                            <Select
                                labelId="scienceFoldMirrorType"
                                id="scienceFoldMirrorType"
                                value={foldMirrorType}
                                label="Type of the fold mirror"
                                onChange={handleFoldMirrorTypeChange}
                            >
                                <MenuItem value="">
                                    <em>None</em>
                                </MenuItem>
                                <MenuItem value="CASSEGRAIN_FOCUS">Cassegrain focus</MenuItem>
                                <MenuItem value="REFLECTIVE_CONVERGING_BEAM">Reflective converging beam</MenuItem>
                            </Select>
                        </FormControl>
                        <FormControl margin='normal' fullWidth>
                            <InputLabel required id="moduleContent">
                                Module Content
                            </InputLabel>
                            <Select
                                labelId="moduleContent"
                                id="moduleContent"
                                value={moduleContent}
                                label="Module Content"
                                onChange={handleModuleContentChange}
                            >
                                <MenuItem value="">
                                    <em>None</em>
                                </MenuItem>
                                <MenuItem value={"1"}>Module 1: Acquisition Camera/High Resolution Wavefront Sensor</MenuItem>
                                <MenuItem value={"2"}>Module 2: Science Fold</MenuItem>
                                <MenuItem value={"3"}>Module 3: Second Peripheral Wavefront Sensor</MenuItem>
                                <MenuItem value={"4"}>Module 4: First Peripheral Wavefront Sensor (Closest to the Sky)</MenuItem>
                            </Select>
                        </FormControl>

                        <FormControl margin='normal' fullWidth>
                            <InputLabel required id="calibrationUnit">
                                Calibration Unit (GCAL) Lamp Name
                            </InputLabel>
                            <Select
                                labelId="calibrationUnit"
                                id="calibrationUnit"
                                value={calibrationUnit}
                                label="Calibration Unit (GCAL) Lamp Name"
                                onChange={handleCalibrationUnitChange}
                            >
                                <MenuItem value="">
                                    <em>None</em>
                                </MenuItem>
                                <MenuItem value="Argon">Argon</MenuItem>
                                <MenuItem value="Xenon">Xenon</MenuItem>
                                <MenuItem value="ThAr">ThAr</MenuItem>
                                <MenuItem value="CuAr">CuAr</MenuItem>
                            </Select>
                        </FormControl>

                        <FormControl margin='normal' fullWidth>
                            <InputLabel required id="lightType">
                                Light type (for light detector)
                            </InputLabel>
                            <Select
                                labelId="lightType"
                                id="lightType"
                                value={lightType}
                                label="Light type (for light detector)"
                                onChange={handleLightTypeChange}
                            >
                                <MenuItem value="">
                                    <em>None</em>
                                </MenuItem>
                                <MenuItem value="MaunaKeaSkyEmission">Mauna Kea Sky Emission</MenuItem>
                                <MenuItem value="CerroPachonSkyEmission">Cerro Pachon Sky Emission</MenuItem>
                            </Select>
                        </FormControl>


                        <Box sx={{ display: 'flex', flexDirection: 'column', alignItems: 'end' }}>
                            {telePositionPairs.map((telePositionPair, index) => (
                                <Grid container spacing={2} key={index}>
                                    <Grid item xs={index === 0 && telePositionPairs.length > 1 ? 6 : 5}>
                                        <TextField
                                            margin="normal"
                                            required
                                            fullWidth
                                            type="number"
                                            label={`Teleposition Pair ${index + 1} Direction`}
                                            value={telePositionPair.direction}
                                            onChange={(e) => handleTelePositionPairChange(index, 'direction', e.target.value)}
                                        />
                                    </Grid>
                                    <Grid item xs={index === 0 && telePositionPairs.length > 1 ? 6 : 5}>
                                        <TextField
                                            margin="normal"
                                            required
                                            fullWidth
                                            type='number'
                                            label={`Teleposition Pair ${index + 1} Degree`}
                                            value={telePositionPair.degree}
                                            onChange={(e) => handleTelePositionPairChange(index, 'degree', e.target.value)}
                                        />
                                    </Grid>
                                    {!(index === 0 && telePositionPairs.length > 1) && (
                                        <Grid item xs={2} sx={{ display: 'flex', alignItems: 'center' }}>
                                            {index === telePositionPairs.length - 1 && ( // Conditionally render add button for last index
                                                <Button onClick={addTelePositionPair} variant="text" fullWidth>
                                                    <AddCircleIcon />
                                                </Button>
                                            )}
                                            {index !== 0 && ( // Conditionally render delete button if index is not 0
                                                <Button onClick={() => deleteTelePositionPair(index)} variant="outlined" color="error" sx={{ width: '100%' }}>
                                                    <DeleteOutlineIcon />
                                                </Button>
                                            )}

                                        </Grid>
                                    )}

                                </Grid>
                            ))}
                        </Box>

                        <Button
                            type='submit'
                            variant='contained'
                            fullWidth
                            sx={{ mt: 2 }}
                            endIcon={<SendIcon />}
                            onClick={handleSubmit}
                        >
                            Submit
                        </Button>
                    </Box>
                </Grid>
            </Grid>

        </Grid>
    );
}
