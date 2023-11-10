package com.jdt.itcg.demo.records;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.math.BigDecimal;

public record EmailValidationResponse(
        String email,
        @JsonAlias("autocorrect") String autoCorrector,
        String deliverability,

        @JsonAlias("quality_score")BigDecimal qualityScore,
        @JsonAlias("is_valid_format") CheckProperty validFormat,
        @JsonAlias("is_free_email") CheckProperty freeEmail,

        @JsonAlias("is_role_email") CheckProperty roleEmail,
        @JsonAlias("is_catchall_email") CheckProperty catchAllEmail,
        @JsonAlias("is_mx_found") CheckProperty mxFound,
        @JsonAlias("is_smtp_valid") CheckProperty SMPTValid

) {
}
