package pl.wsikora.kanban.functionalities;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.Test;
import pl.wsikora.kanban.model.entities.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class JsonConverterTest {

    private JsonParser jsonParser = new JsonParser();

    private JsonConverter converter = new JsonConverter();

    private JsonObject parse(String json) {
        return jsonParser.parse(json).getAsJsonObject();
    }

    private LocalDateTime dateTimeParser(String dT) {
        return LocalDateTime.parse(dT.substring(0, dT.length() - 1));
    }

    @Test
    void toAssignee() {
        String json = "{\"id\": 2,\"name\": \"test 1\",\"username\": \"test1\",\"state\": \"active\",\"avatar_url\": \"https://secure.gravatar.com/avatar/b642b4217b34b1e8d3bd915fc65c4452?s=80\\u0026d=identicon\",\"web_url\": \"https://192.168.0.16/test1\"}";
        JsonObject assignee = parse(json);

        Assignee a = new Assignee();
        a.setId(2L);
        a.setUserName("test1");

        assertEquals(a, converter.toAssignee(assignee));
    }

    @Test
    void toAuthor() {
        String json = "{\"id\":2,\"name\":\"test 1\",\"username\":\"test1\",\"state\":\"active\",\"avatar_url\":\"https://secure.gravatar.com/avatar/b642b4217b34b1e8d3bd915fc65c4452?s=80\\u0026d=identicon\",\"web_url\":\"https://192.168.0.16/test1\"}";
        JsonObject author = parse(json);

        Author a = new Author();
        a.setId(2L);
        a.setUserName("test1");
        a.setWebUrl("https://192.168.0.16/test1");

        assertEquals(a, converter.toAuthor(author));
    }

    @Test
    void toGroup() {
        String json = "{\"id\":3,\"web_url\":\"https://192.168.0.16/groups/group-1\",\"name\":\"group 1\",\"path\":\"group-1\",\"description\":\"Nam vestibulum nunc ultricies, facilisis diam a, vulputate magna\",\"visibility\":\"private\",\"share_with_group_lock\":false,\"require_two_factor_authentication\":false,\"two_factor_grace_period\":48,\"project_creation_level\":\"developer\",\"auto_devops_enabled\":null,\"subgroup_creation_level\":\"maintainer\",\"emails_disabled\":null,\"mentions_disabled\":null,\"lfs_enabled\":true,\"default_branch_protection\":2,\"avatar_url\":null,\"request_access_enabled\":true,\"full_name\":\"group 1\",\"full_path\":\"group-1\",\"created_at\":\"2020-08-25T17:45:23.949Z\",\"parent_id\":null}";
        JsonObject group = parse(json);

        Group g = new Group();
        g.setId(3L);
        g.setName("group 1");
        g.setWebUrl("https://192.168.0.16/groups/group-1");

        assertEquals(g, converter.toGroup(group));
    }

    @Test
    void toIssue() {
        String json = "{\"id\":1,\"iid\":1,\"project_id\":2,\"title\":\"Sed cursus\",\"description\":\"Cras placerat velit nec dui scelerisque, ut elementum dui rutrum\",\"state\":\"opened\",\"created_at\":\"2020-08-25T21:24:13.137Z\",\"updated_at\":\"2020-08-25T21:24:13.137Z\",\"closed_at\":null,\"closed_by\":null,\"labels\":[\"Aenean\",\"Fusce\"],\"milestone\":{\"id\":2,\"iid\":1,\"group_id\":3,\"title\":\"Donec luctus\",\"description\":\"Cras a tellus sed neque volutpat euismod\",\"state\":\"active\",\"created_at\":\"2020-08-25T20:18:45.258Z\",\"updated_at\":\"2020-08-25T20:18:45.258Z\",\"due_date\":\"2020-10-21\",\"start_date\":null,\"web_url\":\"https://192.168.0.16/groups/group-1/-/milestones/1\"},\"assignees\":[{\"id\":2,\"name\":\"test 1\",\"username\":\"test1\",\"state\":\"active\",\"avatar_url\":\"https://secure.gravatar.com/avatar/b642b4217b34b1e8d3bd915fc65c4452?s=80\\u0026d=identicon\",\"web_url\":\"https://192.168.0.16/test1\"}],\"author\":{\"id\":2,\"name\":\"test 1\",\"username\":\"test1\",\"state\":\"active\",\"avatar_url\":\"https://secure.gravatar.com/avatar/b642b4217b34b1e8d3bd915fc65c4452?s=80\\u0026d=identicon\",\"web_url\":\"https://192.168.0.16/test1\"},\"assignee\":{\"id\":2,\"name\":\"test 1\",\"username\":\"test1\",\"state\":\"active\",\"avatar_url\":\"https://secure.gravatar.com/avatar/b642b4217b34b1e8d3bd915fc65c4452?s=80\\u0026d=identicon\",\"web_url\":\"https://192.168.0.16/test1\"},\"user_notes_count\":0,\"merge_requests_count\":0,\"upvotes\":0,\"downvotes\":0,\"due_date\":\"2020-10-27\",\"confidential\":false,\"discussion_locked\":null,\"web_url\":\"https://192.168.0.16/group-1/nam-blandit/-/issues/1\",\"time_stats\":{\"time_estimate\":0,\"total_time_spent\":0,\"human_time_estimate\":null,\"human_total_time_spent\":null},\"task_completion_status\":{\"count\":0,\"completed_count\":0},\"has_tasks\":false,\"_links\":{\"self\":\"https://192.168.0.16/api/v4/projects/2/issues/1\",\"notes\":\"https://192.168.0.16/api/v4/projects/2/issues/1/notes\",\"award_emoji\":\"https://192.168.0.16/api/v4/projects/2/issues/1/award_emoji\",\"project\":\"https://192.168.0.16/api/v4/projects/2\"},\"references\":{\"short\":\"#1\",\"relative\":\"#1\",\"full\":\"group-1/nam-blandit#1\"},\"moved_to_id\":null}";
        JsonObject issue = parse(json);

        Issue i = new Issue();
        i.setId(1L);
        i.setTitle("Sed cursus");
        i.setDescription("Cras placerat velit nec dui scelerisque, ut elementum dui rutrum");
        i.setState("opened");
        i.setCreatedAt(dateTimeParser("2020-08-25T21:24:13.137Z"));
        i.setUpdatedAt(dateTimeParser("2020-08-25T21:24:13.137Z"));
        i.setDueDate(LocalDate.parse("2020-10-27"));
        i.setUpVotes(0);
        i.setDownVotes(0);
        i.setWebUrl("https://192.168.0.16/group-1/nam-blandit/-/issues/1");

        assertEquals(i, converter.toIssue(issue));
    }

    @Test
    void toLabel() {
        String json = "{\"id\":1,\"name\":\"Aenean\",\"color\":\"#0033CC\",\"description\":null,\"description_html\":\"\",\"text_color\":\"#FFFFFF\",\"subscribed\":false,\"priority\":null,\"is_project_label\":true}";
        JsonObject label = parse(json);

        Label l = new Label();
        l.setId(1L);
        l.setName("Aenean");
        l.setBackgroundColor("#0033CC");
        l.setTextColor("#FFFFFF");

        assertEquals(l, converter.toLabel(label));
    }

    @Test
    void toMilestone() {
        String json = "{\"id\":1,\"iid\":1,\"project_id\":2,\"title\":\"Vestibulum vestibulum\",\"description\":\"Nam commodo nisl id dolor convallis, non placerat libero sagittis.\\r\\n\",\"state\":\"active\",\"created_at\":\"2020-08-25T20:17:14.099Z\",\"updated_at\":\"2020-08-25T20:17:14.099Z\",\"due_date\":\"2020-09-14\",\"start_date\":null,\"web_url\":\"https://192.168.0.16/group-1/nam-blandit/-/milestones/1\"}";
        JsonObject milestone = parse(json);

        Milestone m = new Milestone();
        m.setId(1L);
        m.setTitle("Vestibulum vestibulum");
        m.setDueDate(LocalDate.parse("2020-09-14"));
        m.setWebUrl("https://192.168.0.16/group-1/nam-blandit/-/milestones/1");

        assertEquals(m, converter.toMilestone(milestone));
    }

    @Test
    void toProject() {
        String json = "{\"id\":2,\"description\":\"Nullam vel augue molestie, semper enim quis, volutpat massa.\",\"name\":\"Nam blandit\",\"name_with_namespace\":\"group 1 / Nam blandit\",\"path\":\"nam-blandit\",\"path_with_namespace\":\"group-1/nam-blandit\",\"created_at\":\"2020-08-25T17:45:56.569Z\",\"default_branch\":\"master\",\"tag_list\":[],\"ssh_url_to_repo\":\"git@192.168.0.16:group-1/nam-blandit.git\",\"http_url_to_repo\":\"https://192.168.0.16/group-1/nam-blandit.git\",\"web_url\":\"https://192.168.0.16/group-1/nam-blandit\",\"readme_url\":\"https://192.168.0.16/group-1/nam-blandit/-/blob/master/README.md\",\"avatar_url\":null,\"forks_count\":0,\"star_count\":0,\"last_activity_at\":\"2020-08-25T21:24:13.421Z\",\"namespace\":{\"id\":3,\"name\":\"group 1\",\"path\":\"group-1\",\"kind\":\"group\",\"full_path\":\"group-1\",\"parent_id\":null,\"avatar_url\":null,\"web_url\":\"https://192.168.0.16/groups/group-1\"},\"_links\":{\"self\":\"https://192.168.0.16/api/v4/projects/2\",\"issues\":\"https://192.168.0.16/api/v4/projects/2/issues\",\"merge_requests\":\"https://192.168.0.16/api/v4/projects/2/merge_requests\",\"repo_branches\":\"https://192.168.0.16/api/v4/projects/2/repository/branches\",\"labels\":\"https://192.168.0.16/api/v4/projects/2/labels\",\"events\":\"https://192.168.0.16/api/v4/projects/2/events\",\"members\":\"https://192.168.0.16/api/v4/projects/2/members\"},\"empty_repo\":false,\"archived\":false,\"visibility\":\"private\",\"resolve_outdated_diff_discussions\":false,\"container_registry_enabled\":true,\"container_expiration_policy\":{\"cadence\":\"1d\",\"enabled\":true,\"keep_n\":10,\"older_than\":\"90d\",\"name_regex\":null,\"name_regex_keep\":null,\"next_run_at\":\"2020-08-29T17:50:24.121Z\"},\"issues_enabled\":true,\"merge_requests_enabled\":true,\"wiki_enabled\":true,\"jobs_enabled\":true,\"snippets_enabled\":true,\"service_desk_enabled\":false,\"service_desk_address\":null,\"can_create_merge_request_in\":true,\"issues_access_level\":\"enabled\",\"repository_access_level\":\"enabled\",\"merge_requests_access_level\":\"enabled\",\"forking_access_level\":\"enabled\",\"wiki_access_level\":\"enabled\",\"builds_access_level\":\"enabled\",\"snippets_access_level\":\"enabled\",\"pages_access_level\":\"private\",\"emails_disabled\":null,\"shared_runners_enabled\":true,\"lfs_enabled\":true,\"creator_id\":2,\"import_status\":\"none\",\"import_error\":null,\"open_issues_count\":1,\"runners_token\":\"BWJEMYTvFZMcyZDneFpZ\",\"ci_default_git_depth\":50,\"public_jobs\":true,\"build_git_strategy\":\"fetch\",\"build_timeout\":3600,\"auto_cancel_pending_pipelines\":\"enabled\",\"build_coverage_regex\":null,\"ci_config_path\":null,\"shared_with_groups\":[],\"only_allow_merge_if_pipeline_succeeds\":false,\"allow_merge_on_skipped_pipeline\":null,\"request_access_enabled\":true,\"only_allow_merge_if_all_discussions_are_resolved\":false,\"remove_source_branch_after_merge\":true,\"printing_merge_request_link_enabled\":true,\"merge_method\":\"merge\",\"suggestion_commit_message\":null,\"auto_devops_enabled\":true,\"auto_devops_deploy_strategy\":\"continuous\",\"autoclose_referenced_issues\":true,\"permissions\":{\"project_access\":null,\"group_access\":{\"access_level\":50,\"notification_level\":3}}}";
        JsonObject project = parse(json);

        Project p = new Project();
        p.setId(2L);
        p.setName("Nam blandit");
        p.setWebUrl("https://192.168.0.16/group-1/nam-blandit");

        assertEquals(p, converter.toProject(project));
    }

}
