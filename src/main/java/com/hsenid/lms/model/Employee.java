package com.hsenid.lms.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

import static java.util.Map.entry;

@Data
@Document(collection = "employees")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {

    @Id
    private String id;
    private String name;
    private String email;
    private String position;
    private Map<LeaveType , Double> remainingLeaves = Map.ofEntries(
            entry(LeaveType.ANNUAL_LEAVE, 14.0),
            entry(LeaveType.SICK_LEAVE, 7.0),
            entry(LeaveType.CASUAL_LEAVE, 7.0)
            );
}
