package com.cleancoder.args;

import java.util.Iterator;

public interface ArgumentSetter {
  void set(Iterator<String> currentArgument) throws ArgsException;
}
