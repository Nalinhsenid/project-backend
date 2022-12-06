package com.hsenid.lms.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "leaves")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LeaveRequest {
    @Id
    private String id;
    private Date leaveDate;
    private Boolean isApproved;
}
