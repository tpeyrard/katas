package com.github.tpeyrard.simpleLists;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class simpleListsTest {

    private static final String FIRST_VALUE = "FirstValue";
    private static final String THIRD_VALUE = "ThirdValue";
    private static final String SECOND_VALUE = "SecondValue";

    @Parameterized.Parameter(value = 0)
    public String name;
    @Parameterized.Parameter(value = 1)
    public SimpleList list;
    @Parameterized.Parameter(value = 2)
    public Class<LinkedList.Node> nodeClass;

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"SimpleLinkedList", new LinkedList(), LinkedList.Node.class},
                {"DoubleLinkedList", new DoubleLinkedList(), DoubleLinkedList.Node.class}
        });
    }

    @Before
    public void setUp() {
        list.reset();
    }

    @Test
    public void
    it_returns_null_if_value_is_not_found() {
        assertThat(list.find("absent")).isNull();
    }

    @Test
    public void
    a_list_of_size_zero_is_empty() {
        assertThat(list.isEmpty()).isTrue();
    }

    @Test
    public void
    a_list_with_element_is_not_empty() {
        list.add(FIRST_VALUE);
        assertThat(list.isEmpty()).isFalse();
    }

    @Test
    public void
    it_can_add_a_value_in_the_list() {
        String value = "Thomas";
        list.add(value);
        assertThat(list.find(value)).isNotNull();
    }

    @Test
    public void
    it_can_add_several_values_in_the_list() {
        list.add(FIRST_VALUE);
        list.add(SECOND_VALUE);
        list.add(THIRD_VALUE);
        assertThat(list.values()).isEqualTo(values(FIRST_VALUE, SECOND_VALUE, THIRD_VALUE));
    }

    @Test
    public void
    it_finds_value_present_in_the_list() {
        list.add(FIRST_VALUE);
        list.add(SECOND_VALUE);
        list.add(THIRD_VALUE);
        assertThat(list.find(SECOND_VALUE).value()).isEqualTo(SECOND_VALUE);
    }

    @Test
    public void
    it_can_delete_first_element() {
        list.add(FIRST_VALUE);
        list.add(SECOND_VALUE);
        list.delete(list.find(FIRST_VALUE));

        assertThat(list.values()).isEqualTo(values(SECOND_VALUE));
    }

    @Test
    public void
    it_can_delete_any_value() {
        list.add(FIRST_VALUE);
        list.add(SECOND_VALUE);
        list.add(THIRD_VALUE);

        list.delete(list.find(SECOND_VALUE));

        assertThat(list.values()).isEqualTo(values(FIRST_VALUE, THIRD_VALUE));
    }

    @Test
    public void
    it_can_delete_last_element() {
        list.add(FIRST_VALUE);
        list.add(SECOND_VALUE);
        list.add(THIRD_VALUE);

        list.delete(list.find(THIRD_VALUE));

        assertThat(list.values()).isEqualTo(values(FIRST_VALUE, SECOND_VALUE));
    }

    @Test
    public void
    node_element_should_implement_equals_and_hashcode() {
        nodeClass = LinkedList.Node.class;
        EqualsVerifier.forClass(nodeClass)
                .withIgnoredFields("next")
                .withPrefabValues(nodeClass,
                        list.add(FIRST_VALUE).find(FIRST_VALUE),
                        list.add(SECOND_VALUE).find(SECOND_VALUE))
                .verify();
    }

    @Test
    public void
    acceptance_tests() {

        assertThat(list.find("fred")).isNull();
        list.add("fred");
        assertThat(list.find("fred").value()).isEqualTo("fred");
        assertThat(list.find("wilma")).isNull();
        list.add("wilma");
        assertThat(list.find("fred").value()).isEqualTo("fred");
        assertThat(list.find("wilma").value()).isEqualTo("wilma");
        assertThat(list.values()).isEqualTo(values("fred", "wilma"));


        list.reset();
        list.add("fred");
        list.add("wilma");
        list.add("betty");
        list.add("barney");
        assertThat(list.values()).isEqualTo(values("fred", "wilma", "betty", "barney"));
        list.delete(list.find("wilma"));
        assertThat(list.values()).isEqualTo(values("fred", "betty", "barney"));
        list.delete(list.find("barney"));

        assertThat(list.values()).isEqualTo(values("fred", "betty"));
        list.delete(list.find("fred"));
        assertThat(list.values()).isEqualTo(values("betty"));
        list.delete(list.find("betty"));
        assertThat(list.values()).isEqualTo(values());
    }

    private String[] values(String... values) {
        return values;
    }


}