package com.cleancoder.args;

import java.util.*;

import static com.cleancoder.args.ArgsException.ErrorCode.*;

class ParseSchema {
  private Map<Character, ArgumentMarshaler> marshalers;
  private ListIterator<String> currentArgument;
    private static Map<Character, String> type;


  public ParseSchema(String schema) throws ArgsException {
    marshalers = new HashMap<Character, ArgumentMarshaler>();
    type = new HashMap<Character,String>();
    parseSchema(schema);
  }
  public ParseSchema() throws ArgsException{

  }

  public void parseSchema(String schema) throws ArgsException {
    for (String element : schema.split(","))
      if (element.length() > 0)
        parseSchemaElement(element.trim());
  }

  private void parseSchemaElement(String element) throws ArgsException {
    char elementId = element.charAt(0);
    String elementTail = element.substring(1);
    validateSchemaElementId(elementId);
    if (elementTail.length() == 0)
    {
      marshalers.put(elementId, new BooleanArgumentMarshaler());
      type.put(elementId,"Boolean");
    }
    else if (elementTail.equals("*"))
    {
      marshalers.put(elementId, new StringArgumentMarshaler());
      type.put(elementId,"String");
    }
    else if (elementTail.equals("#"))
    {
      marshalers.put(elementId, new IntegerArgumentMarshaler());
      type.put(elementId,"Integer");
    }
    else if (elementTail.equals("##"))
    {
      marshalers.put(elementId, new DoubleArgumentMarshaler());
      type.put(elementId,"Double");
    }
    else if (elementTail.equals("[*]"))
    {
      marshalers.put(elementId, new StringArrayArgumentMarshaler());
      type.put(elementId,"StringArray");
    }
    else if (elementTail.equals("&"))
    {
      marshalers.put(elementId, new MapArgumentMarshaler());
      type.put(elementId,"Map");
    }
    else
      throw new ArgsException(INVALID_ARGUMENT_FORMAT, elementId, elementTail);
  }

  private void validateSchemaElementId(char elementId) throws ArgsException {
    if (!Character.isLetter(elementId))
      throw new ArgsException(INVALID_ARGUMENT_NAME, elementId, null);
  }

  public Map<Character, ArgumentMarshaler> getMap()throws ArgsException {
    return marshalers;
  }

   public Map<Character, String> gettypeMap()throws ArgsException {
    return type;
  }



  
}