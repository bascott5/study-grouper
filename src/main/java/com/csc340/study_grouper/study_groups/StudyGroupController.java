package com.csc340.study_grouper.study_groups;

import com.csc340.study_grouper.messages.MessagesService;
import com.csc340.study_grouper.users.UsersController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/group")
public class StudyGroupController {

    @Autowired
    MessagesService messageService;

    @Autowired
    StudyGroupService studyGroupService;

    @GetMapping("/{gID}")
    public String studyGroupPage(@PathVariable int groupID){
        return "customer-group-view";
    }

    @GetMapping("/search/{query}")
    public String searchStudyGroups(@PathVariable String query) {
        StudyGroup[] studyGroups = (StudyGroup[]) studyGroupService.searchStudyGroups(query).toArray();
        String template = "";

        for (int i = 0; i < studyGroups.length; i++) {
            template.concat(String.format("""
                <hr>
                <div>
                    <h2><a href="/customer/group-description/%s">%s</a></h2>
                </div>\n
                """, studyGroups[i].getGroupID(), studyGroups[i].getGroupName()));
        }

        return template;
    }


}
