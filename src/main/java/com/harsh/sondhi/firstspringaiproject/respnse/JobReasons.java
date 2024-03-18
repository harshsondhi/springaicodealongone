package com.harsh.sondhi.firstspringaiproject.respnse;

import java.util.List;

public record JobReasons(String job,
                         String location,
                         List<String> reasons) {
}
