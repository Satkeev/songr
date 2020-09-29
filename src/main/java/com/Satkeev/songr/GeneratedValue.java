package com.Satkeev.songr;

import javax.persistence.GenerationType;

public @interface GeneratedValue {
    GenerationType strategy();
}
