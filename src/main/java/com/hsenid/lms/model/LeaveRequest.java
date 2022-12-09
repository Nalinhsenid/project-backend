package com.hsenid.lms.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "leaves")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LeaveRequest {

    private String employeeId;
    private Date leaveDate;
    private LeaveType leaveType;
    private Float leaveAmount;
    private Boolean isApproved;
}
