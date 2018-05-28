package com.care.open.weather.model

import com.fasterxml.jackson.databind.ObjectMapper
import spock.lang.Specification

import java.lang.reflect.Field

abstract class ModelBaseTest extends Specification {

  protected ClassLoader classLoader = getClass().getClassLoader()
  protected ObjectMapper objectMapper = new ObjectMapper()

  void noNullFields(def obj) {
    obj.getClass().declaredFields.each {Field field ->
      field.setAccessible(true)
      def subObject = field.get(obj)
      assert subObject != null, "Filed ${field.name} is null in ${obj.getClass()}"

      if (!field.type.isPrimitive()
          && String.class != field.type
          && Boolean.class != field.type
          && Class.class != field.type
          && !Number.class.isAssignableFrom(field.type)
          && !Enum.class.isAssignableFrom(field.type)
          && !Map.class.isAssignableFrom(field.type)) {

        if (List.class.isAssignableFrom(field.type) || Set.class.isAssignableFrom(field.type)) {
          subObject.each {
            noNullFields(it)
          }
        } else {
          noNullFields(subObject)
        }
      }
    }
  }
}