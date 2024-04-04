# OCSDemo: This is the demo project for using the OCS library

**V1.3** 7 April 2023 - This version has the following fixes.
1. A science plan can be created and saved to OCS.
2. A science plan can be tested after being saved in OCS (this used to be allowed only after submitting).

**V1.2** 1 April 2022 - This version has the following fixes.
1. Added the support for observing program creation.
 
**V1.1** 5 May 2021 - This version has the following fixes.
1. Fixed the `toString()` of `SciencePlan` to handle null values. 
2. Fixed the automatic downloading of star images when a science plan is returned by Spring Data JPA.
3. Added `implements Serializable` to `DataProcRequirements` class.

**Note:** _This is an ongoing development. So this document will be kept udpated overtime._

## OCS Class Diagram 

![OCS Class Diagram](https://github.com/ICT-Mahidol/Gemini-2021/blob/master/figures/Class-OCS-2022.png "OCS Class Diagram")

## Description
The available functions are as follows.
| Function | Parameters | Return value | Description |
|----------|--------------|-------------|------------|
| `ArrayList<SciencePlan> getAllSciencePlans()` | N/A | List of science plan objects | Get a list of all science plans in the OCS system |
| `SciencePlan getSciencePlanByNo(int planNo)` | the plan no. to retrieve | The selected science plan object | Get a specific science plan in the OCS system |
| `String submitSciencePlan(SciencePlan sp)` | the science plan object to submit | A string containing the submission result | Submit a new science plan into the OCS system |
| `boolean updateSciencePlanStatus(int planno, SciencePlan.STATUS stssp)` | the plan no. to update, the status | true=success, false=failed | Update the status of an existing science plan |
| `String testSciencePlan(SciencePlan sp)` | the science plan to test | A string showing the result of the tests | Testing the submitted science plan to make sure it contains all correct information |
| `void deleteAllSciencePlans()` | N/A | N/A | Delete all science plans in the OCS system |
| `boolean deleteSciencePlanByNo(int planNo)` | the plan no. to delete | true=success, false=failed | Delete a specific science plan |  
| `AstronomicalData getAstronomicalData(SciencePlan sp)` | the science plan to get the astronomical data | Collect astronomical data | Get the collected astronomical data of a given science plan |
| `String accessTelescopeLiveView()` | N/A | A link to the live view (video) of the telescope | Get the live view of the telescope |
| `String executeCommand(String command)` | a command line string to be executed | A string showing the result of the command |
| `String getConfigurations()` | N/A | A string showing the content in the installed configurations | Getting the configurations in the Gemini system |
| `boolean addConfiguration(String confFilePath)` | the file path of the configuration to be added to the operation table | true=successful, false=failed | Adding a new configuration to the Gemini system |
| `boolean boolean removeConfiguration(int confNo)` | the no. of the configuration to remove | true=successfully removed, false=failed to remove | Remove a configuration that has already been installed in the system |
| `ObservingProgramConfigs.FoldMirrorType[] getFoldMirrorTypes()` | N/A | List of the fold mirror types | Get the list of fold mirror types (used in Observing Program) |
| `ObservingProgramConfigs.CalibrationUnit[] getCalibrationUnits()` | N/A | List of the calibration units | Get the list of calibration units (used in Observing Program) |
| `ObservingProgramConfigs.LightType[] getLightTypes()` | N/A | List of light types | Get the list of light types (used in Observing Program) |
| `ObservingProgram createObservingProgram(SciencePlan sp, String opticsPrimary, double fStop, double opticsSecondaryRMS, double scienceFoldMirrorDegree, ObservingProgramConfigs.FoldMirrorType scienceFoldMirrorType, int moduleContent, ObservingProgramConfigs.CalibrationUnit calibrationUnit, ObservingProgramConfigs.LightType lightType, TelePositionPair[] telePositionPair)` | See details of the parameters from the Javadoc [here](https://cragkhit.github.io/files/ocs_docs/) | The created observing program | Create a new observing program. | 
| `ObservingProgram[] getObservingPrograms()` | N/A | List of observing programs | Get the list of all observing programs |
| `ObservingProgram getObservingProgramBySciencePlan(SciencePlan sp)` | A science plan | The observing program of a given science plan | Get the observing program associated with the given science plan |

## How to:
1. Clone the project.
2. Open the project in IntelliJ or Eclipse.
3. Add "OCS.jar" as a library.
4. Run the `Main` class and see what happens.
5. If you want to use the OCS in your own project, please copy the `ocs.jar`, the `references` folder, and the `ocs.mv.db` files to your project.
6. Configure the dependencies in build.gradle

```gradle
dependencies {
	...

	// OCS
	implementation files("lib/OCS.jar")
}
```

## More information about the Star Systems, Data Processing Requirements, and Observing Program
1. [Star systems and their observation dates](https://github.com/ICT-Mahidol/Gemini-2022/blob/master/OCS-Demo/docs/Star_System_Observation_Dates.pdf)
2. [Science plan's data processing requirements](https://github.com/ICT-Mahidol/Gemini-2022/blob/master/OCS-Demo/docs/Data_Proc_Requirements.pdf)
3. [Observing program](https://github.com/ICT-Mahidol/Gemini-2022/blob/master/OCS-Demo/docs/Observing_Program_Value_Ranges.pdf)

## Issue report
1. If you find any issue, please create an issue in this repo and assign to @cragkhit and @morakotch. We'll fix them as soon as possible.
