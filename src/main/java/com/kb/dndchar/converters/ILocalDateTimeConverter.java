package com.kb.dndchar.converters;

import java.time.LocalDateTime;

public interface ILocalDateTimeConverter {

     LocalDateTime convertLongToLocalDateTime(Long epoch);
     Long convertLocalDateTimeToLong(LocalDateTime localDateTime);
}