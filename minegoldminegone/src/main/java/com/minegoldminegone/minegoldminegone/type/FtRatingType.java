package com.minegoldminegone.minegoldminegone.type;

import lombok.Getter;

@Getter
public enum FtRatingType {
  GOOD("1"),
  BAD("0"),
  UNDEFIENED(null);

  private String type;
  FtRatingType(String type) {
    this.type = type;
  }
}
