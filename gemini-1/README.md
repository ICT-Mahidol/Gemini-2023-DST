
# Gemini Project by Group NongNay 🪐 🌍 🌕

This project is part of ITDS361 Software Design and Development.

## Members

- [6487091 Supasan Liengchaisiri](https://github.com/Supasan27)
- [6487061 Sunpetch Siripunt](https://github.com/6487061)
- [6487034 Thanaddanai Yongpisanphop](https://github.com/ThanaSavey)
- [6487075 Chaicharoen Charoenchai](https://github.com/chaicharoen6487075)
- [6487089 Sornvisit Chanpen](https://github.com/Sornvisit)



## How to run this project

Using Docker image

Start server
```bash
  docker-compose up --build
```
Stop server
```bash
  docker-compose down
```
Use case #3 Validate a Science plan.

-Open browser and go to [localhost:8080](http://localhost:8080)

Use case#1 Create an Observing Program and Use case#2 Validate an Observing program


-After create observing program, you can see all observing programs here-> [localhost:8080/observing-programs](http://localhost:8080/observing-programs) then you can validate observing-programs(for telescope operator)
    
## Design Pattern
Facade Pattern 
- In ObservingProgramService.java, there are methods responsible for converting data from an internal application model (com.example.demo.model.ObservingProgram) to another model used by an external system (edu.gemini.app.ocs.model.ObservingProgram). This service handles the complex data transformations between the application and an external system. This pattern is used to hide the complexities of these transformations and operations from the controllers that interact with this service.
```javascript
public class ObservingProgramService {

    public ObservingProgram convertToOcsModel(com.example.demo.model.ObservingProgram demoModel) {
        ObservingProgram ocsModel = new ObservingProgram();
        ocsModel.setPlanNo(demoModel.getId());
        ocsModel.setOpticsPrimary(demoModel.getOpticsPrimary());
        ocsModel.setfStop(demoModel.getfStop());
        ocsModel.setOpticsSecondaryRMS(demoModel.getOpticsSecondaryRMS());
        ocsModel.setScienceFoldMirrorDegree(demoModel.getScienceFoldMirrorDegree());
        ocsModel.setCalibrationUnit(ObservingProgramConfigs.CalibrationUnit.valueOf(demoModel.getCalibrationUnit()));
        ocsModel.setLightType(ObservingProgramConfigs.LightType.valueOf(demoModel.getLightType()));
        ocsModel.setTelePositionPair(convertStringToTelePositionPairs(demoModel.getTelePositionPairs()));
        return ocsModel;
    }

    public TelePositionPair[] convertStringToTelePositionPairs(String telePositionPairsString) {
        String[] pairs = telePositionPairsString.split(",");
        TelePositionPair[] telePositionPairs = new TelePositionPair[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            String[] parts = pairs[i].split("-");
            // Parse direction and degree assuming they are properly formatted as doubles
            double direction = Double.parseDouble(parts[0]);
            double degree = Double.parseDouble(parts[1]);
            // Create a new TelePositionPair object with the parsed direction and degree
            telePositionPairs[i] = new TelePositionPair(direction, degree);
        }
        return telePositionPairs;
    }
}
```
Singleton Pattern 
- ObservingProgramService is annotated with @Service, which instructs the Spring Framework to manage this class as a singleton by default. This means that an instance of ObservingProgramService will be created once and reused wherever it's referenced.

```javascript
@Service
public class ObservingProgramService {
    ...
}
```
- ObservingProgramRepository, which is an interface extending JpaRepository and annotated with @Repository, the use of @Repository ensures that Spring manages this interface as a singleton as well, ensuring that database access through this repository occurs via a single instance managed by Spring.

```javascript
@Repository
public interface ObservingProgramRepository extends JpaRepository<ObservingProgram, Integer> {
}
```


