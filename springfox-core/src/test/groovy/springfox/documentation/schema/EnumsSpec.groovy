package springfox.documentation.schema

import spock.lang.Specification
import springfox.documentation.service.AllowableListValues

import static com.google.common.collect.Lists.*

class EnumsSpec extends Specification {
  def "enums support @JsonValue annotation"() {
    given:
      def expected = new AllowableListValues(newArrayList("One", "Two"), "LIST")
    expect:
      expected.getValues() == Enums.allowableValues(JsonValuedEnum).getValues()

  }

  def "enums support regular enums"() {
    given:
      def expected = new AllowableListValues(newArrayList("ONE", "TWO"), "LIST")
    expect:
      expected.getValues() == Enums.allowableValues(ExampleEnum).getValues()
  }

  def "enums work with incorrectly annotated enums"() {
    given:
      def expected = new AllowableListValues(newArrayList("ONE", "TWO"), "LIST")
    expect:
      expected.getValues() == Enums.allowableValues(IncorrectlyJsonValuedEnum).getValues()
  }

  def "Enums class in not instantiable"() {
    when:
      new Enums()
    then:
      thrown(UnsupportedOperationException)
  }
}