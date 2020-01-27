package com.cleancoder.args;

import java.util.*;

import static com.cleancoder.args.ArgsException.ErrorCode.*;

public class Args {
  private Map<Character, ArgumentSetter> marshalers;
  private Set<Character> argsFound;
  private ListIterator<String> currentArgument;

  public Args(String schema, String[] args) throws ArgsException {
    marshalers = new HashMap<Character, ArgumentSetter>();
    argsFound = new HashSet<Character>();

    ParseSchema ps = new ParseSchema(schema);
    marshalers = ps.getMap();
    ParseArgument ps2 = new ParseArgument(Arrays.asList(args),marshalers);
    argsFound = ps2.getSet();
    currentArgument=ps2.getList();
  }
  public boolean has(char arg) {
    return argsFound.contains(arg);
  }

  public int nextArgument() {
    return currentArgument.nextIndex();
  }

  public boolean getBoolean(char arg) {
    return BooleanSetter.getValue(marshalers.get(arg));
  }

  public String getString(char arg) {
    return StringSetter.getValue(marshalers.get(arg));
  }

  public int getInt(char arg) {
    return IntegerSetter.getValue(marshalers.get(arg));
  }

  public double getDouble(char arg) {
    return DoubleSetter.getValue(marshalers.get(arg));
  }

  public String[] getStringArray(char arg) {
    return StringArraySetter.getValue(marshalers.get(arg));
  }

  public Map<String, String> getMap(char arg) {
    return MapSetter.getValue(marshalers.get(arg));
  }
}
