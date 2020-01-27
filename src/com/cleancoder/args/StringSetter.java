package com.cleancoder.args;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static com.cleancoder.args.ArgsException.ErrorCode.MISSING_STRING;

public class StringSetter implements ArgumentSetter {
  private String stringValue ;

  public StringSetter() throws ArgsException{
    this.stringValue = "";

  }

  public void set(Iterator<String> currentArgument) throws ArgsException {
    try {
      stringValue = currentArgument.next();
    } catch (NoSuchElementException e) {
      throw new ArgsException(MISSING_STRING);
    }
  }

  public static String getValue(ArgumentSetter am) {
    if (am != null && am instanceof StringSetter)
      return ((StringSetter) am).stringValue;
    else
      return "";
  }
}
