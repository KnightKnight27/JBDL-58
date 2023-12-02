package com.example.minorproject.dtos;

import com.example.minorproject.models.TransactionType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IntiateTransactionRequest {

    private Integer adminId;
    private Integer studentId;

    private Integer bookId;

    private TransactionType transactionType;

}
