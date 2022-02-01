package practice.demo;


import org.springframework.web.bind.annotation.RequestMapping;
import practice.demo.Services.DeveloperService;
import practice.demo.Services.PushNotification;
import practice.demo.Services.TeamService;
import practice.demo.entities.Developers;
import practice.demo.entities.Team;

import java.net.http.HttpClient;


public class ServiceController {

    private TeamService teamService;
    public PushNotification pushNotification;
    DeveloperService developerService;

    @RequestMapping(mappings="rest\create", method = HTTP.POST)
    public String createTeam(Team team , List<Developers> developersList) {
        return teamService.createTeam(team,developersList);
    }

    @RequestMapping(mapping = "rest\\send\alert",method = HTTP.POST)
    public String sendNotification(String phone_number, String message, String type) {
        return pushNotification.sendMessage(phone_number, message);
    }

    @RequestMapping(mapping="rest\alert", method = HTTP.PUST)
    public String setAlert(String entity_type,String entity_id, String rule_id) {
        //hashMap of rule and List<developers>
        //if entityType Team--->fetch all the developers and add to the developers list
        //if entityType is a developer --->add it to developers list
        if(entity_type.equals(Team)) {
            List<Developers> developersList = developerService.getDevelopersFromTeam(entity_id);
            List<Developers> developersList1 = developerService.getDevelopersFromRule();
            developersList1.add(developersList);
            developerService.save(developersList1);
        }
        else {
            List<Developers> developersList1 = developerService.getDevelopersFromRule();
            Developers developer = developerService.getDeveloperById(entity_id);
            developersList1.add(developer);
            developerService.save(developersList1);
        }

    }
}





//
//    We can create teams, and map a set of developers to those teams. When an alert is raised by the alerting
//        system for a team, an sms needs to be sent to one of the developers of that team.
//        We have 2 entities:
//        Team: id, name
//        Developer: id, team_id, name, phone number
//
//        - Create team api - This api takes in a team and a list of developers to be mapped with this team, and is
//        expected to create the corresponding entries in the database.
//        Sample request: {"team": {"name": "claims"}, "developers": [{"name
//        Sample request: {"team": {"name": "claims"}, "developers": [{"name": "someone", "phone_number":
//        "9999999999"}, {"name": "somebody", "phone_number": "9111111111"}]}
//We will define alerting rules and Set alert service will set preconfigured rules to send alert in future
//{"rule": {"name"}}
//        Sample Request: {"entity_type": "team/developer", "rule_id"}
//        Notification service api: POST https://run.mocky.io/v3/fd99c100-f88a-4d70-aaf7-393dbbd5d99f
//        Sample request: {"phone_number": "9999999999", "message": "Too many 5xx!"}


//- Write 1-2 sample unit test cases - no need to be exhaustive - but the ones that are written should be
//        production quality
//        - Use external database, build on your local machine, take help from internet wherever needed, copy
//        paste code snippets if needed
//        - Try to be as close as possible to production quality coding conventions
//        - Handle failures wherever applicable
//        - Since time is limited, please prioritize tasks in the order they have been mentioned in the problem.

//    We are not building this for scale, so let's limit the tech stack to code and external database in the
//        interest of time. We are also not assessing choice of tech stack, so anything that you are comfortable with
//        is fine.