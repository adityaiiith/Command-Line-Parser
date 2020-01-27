package com.cleancoder.args;

import java.util.Iterator;

public class BooleanSetter implements ArgumentSetter {
  private boolean booleanValue;

   public BooleanSetter() throws ArgsException{
    this.booleanValue = false;

  }
  public void set(Iterator<String> currentArgument) throws ArgsException {
    booleanValue = true;
  }


  public static boolean getValue(ArgumentSetter am) {
    if (am != null && am instanceof BooleanSetter)
      return ((BooleanSetter) am).booleanValue;
    else
      return false;
  }
}
