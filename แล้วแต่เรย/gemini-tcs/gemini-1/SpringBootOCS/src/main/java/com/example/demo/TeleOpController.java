package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import edu.gemini.app.ocs.OCS;

import java.util.Objects;

@Controller
public class TeleOpController {
    private static boolean checker = false;
    private final String[] commandList =
            {
                    "GetVersion",
                    "GetStatus",
                    "RunTest",
                    "START",
                    "STOP",
                    "UP",
                    "DOWN",
                    "LEFT",
                    "RIGHT",
                    "FOCUS",
                    "TAKE_PHOTO"
            };
    public String role = "Telescope Operator";

    @GetMapping("teleop")
    public String teleop() {
        return "teleop";
    }

    @GetMapping("commandline")
    public String commandlinerec() {
        return "commandline";
    }

    @PostMapping("commandline")
    public String commandlineres(@RequestParam("command") String command, Model model) {
        OCS o = ocs.getInstance();
        boolean isInCommandList = false;
        for (String cmd : commandList) {
            if (cmd.equals(command)) {
                isInCommandList = true;
                break;
            }
        }
        if (isInCommandList) {
            if (command.equals("GetVersion") || command.equals("GetStatus")) {
                String messageReceived = o.executeCommand(command);
                model.addAttribute("received", command);
                model.addAttribute("result", messageReceived);
                return "commandline";
            } else if (command.equals("START")) {
                checker = true;
                String messageReceived = o.executeCommand(command);
                model.addAttribute("received", command);
                model.addAttribute("result", messageReceived);
                return "commandline";
            } else if (command.equals("STOP")) {
                checker = false;
                String messageReceived = o.executeCommand(command);
                model.addAttribute("received", command);
                model.addAttribute("result", messageReceived);
            } else {
                if (checker) {
                    String messageReceived = o.executeCommand(command);
                    model.addAttribute("received", command);
                    model.addAttribute("result", messageReceived);
                    return "commandline";
                } else {
                    model.addAttribute("received", command);
                    model.addAttribute("result", "Please start the virtual telescope first");
                    return "commandline";
                }
            }
        } else {
            model.addAttribute("received", command);
            model.addAttribute("result", "Incorrect command, please type the correct command");
            return "commandline";
        }

        return  "commandline";
    }

}