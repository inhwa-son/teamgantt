package com.adop.teamgantt.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class TasksBody {

    private final String allow_scheduling_on_holidays;
    private final checklist_info checklist_info;
    private final String color;
    private final comment_info comment_info;
    private final Integer company_id;
    private final Integer days;
    private final dependencies dependencies;
    private final document_info document_info;
    private final String end_date;
    private final String estimate;
    private final Integer estimated_hours;
    private final String expected_percent_complete;
    private final Boolean has_tracked_time;
    private final Integer id;
    private final Boolean is_estimated_hours_enabled;
    private final Boolean is_starred;
    private final Boolean is_time_tracking_enabled;
    private final String name;
    private final Integer parent_group_id;
    private final String parent_group_name;
    private final Integer percent_complete;
    private final Integer project_id;
    private final Boolean project_is_starred;
    private final String project_name;
    private final String project_permission;
    private final List<resources> resources;
    private final Integer sort;
    private final String start_date;
    private final String type;
    private final String wbs;
    private final String work_days_left;


    @Getter
    @AllArgsConstructor
    public static class checklist_info {
        private final Integer count;
        private final Integer completed;
    }

    @Getter
    @AllArgsConstructor
    public static class comment_info {
        private final Integer count;
        private final Boolean has_unread;
    }

    @Getter
    @AllArgsConstructor
    public static class dependencies {
        private final List<String> parents;
        private final List<String> children;
    }

    @Getter
    @AllArgsConstructor
    public static class document_info {
        private final Integer count;
        private final String edit_date;
        private final String view_date;
        private final Boolean has_unread;
    }

    @Getter
    @AllArgsConstructor
    public static class resources {
        private final String color;
        private final Integer hours_per_day;
        private final Integer id;
        private final String name;
        private final String pic;
        private final Integer project_id;
        private final Integer task_id;
        private final Integer total_hours;
        private final String type;
        private final Integer type_id;
    }

}


