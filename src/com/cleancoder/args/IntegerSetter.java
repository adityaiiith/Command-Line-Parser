package com.cleancoder.args;

import static com.cleancoder.args.ArgsException.ErrorCode.*;

import java.util.*;

public class IntegerSetter implements ArgumentSetter {
  private int intValue;

  public IntegerSetter() throws ArgsException{
    this.intValue = 0;

  }

  public void set(Iterator<String> currentArgument) throws ArgsException {
    String parameter = null;
    try {
      parameter = currentArgument.next();
      intValue = Integer.parseInt(parameter);
    } catch (NoSuchElementException e) {
      throw new ArgsException(MISSING_INTEGER);
    } catch (NumberFormatException e) {
      throw new ArgsException(INVALID_INTEGER, parameter);
    }
  }

  public static int getValue(ArgumentSetter am) {
    if (am != null && am instanceof IntegerSetter)
      return ((IntegerSetter) am).intValue;
    else
      return 0;
  }
}
