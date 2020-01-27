package com.cleancoder.args;

import java.util.*;
import static com.cleancoder.args.ArgsException.ErrorCode.*;


public class ParseArgument
{

  private Set<Character> argsFound;
  private Map<Character, ArgumentMarshaler> marshalers;
  //private Map<Character, String> type;

  private ListIterator<String> currentArgument;
  
  public ParseArgument(List<String> argsList, Map<Character, ArgumentMarshaler> map) throws ArgsException 
  {
    argsFound = new HashSet<Character>();
    marshalers = new HashMap<Character, ArgumentMarshaler>();
    //type = new Map<Character,String>();
    marshalers = map;
    parseArgumentStrings(argsList);
}

private void parseArgumentStrings(List<String> argsList) throws ArgsException {
  int count = 1;
    for (currentArgument = argsList.listIterator(); currentArgument.hasNext();) {
      String argString = currentArgument.next();
      if (argString.startsWith("-")) {
        if(argString.substring(1).length() == 1)
        {
          parseArgumentCharacters(argString.substring(1));
        }
        else
        {
          if(count==1)
          throw new ArgsException(UNEXPECTED_STRING_ARGUMENT, argString, null);
        }
      } else {
        currentArgument.previous();
        break;
      }
    }
  }

  private void parseArgumentCharacters(String argChars) throws ArgsException {
    for (int i = 0; i < argChars.length(); i++)
      parseArgumentCharacter(argChars.charAt(i));
  }

  private void parseArgumentCharacter(char argChar) throws ArgsException {
    ArgumentMarshaler m = marshalers.get(argChar);

    if (m == null) {
      throw new ArgsException(UNEXPECTED_ARGUMENT, argChar, null);
    } else {
      argsFound.add(argChar);
      try {
        m.set(currentArgument);
      } catch (ArgsException e) {
        e.setErrorArgumentId(argChar);
        throw e;
      }
    }
  }
  public Set<Character> getSet() throws ArgsException {
    return argsFound;
  }
  public  ListIterator<String> getList() throws ArgsException
  {
    return currentArgument;
  }
}
