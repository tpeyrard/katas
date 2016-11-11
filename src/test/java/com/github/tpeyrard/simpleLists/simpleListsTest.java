package com.github.tpeyrard.simpleLists;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class simpleListsTest {

    public static final String FIRST_VALUE = "FirstValue";
    public static final String THIRD_VALUE = "ThirdValue";
    public static final String SECOND_VALUE = "SecondValue";
    @Parameterized.Parameter
    public SimpleList list;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new LinkedList()}
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
        list.add("Thomas");
        list.add("Maxence");
        list.add("Florine");
        assertThat(list.values()).isEqualTo(new String[]{"Thomas", "Maxence", "Florine"});
    }

    @Test
    public void
    it_finds_value_present_in_the_list() {
        list.add(FIRST_VALUE);
        String value = "Maxence";
        list.add(value);
        assertThat(list.find(value).value()).isEqualTo(value);
    }

    @Test
    public void
    it_can_delete_first_element() {
        list.add(FIRST_VALUE);
        list.delete(list.find(FIRST_VALUE));

        assertThat(list.isEmpty()).isTrue();
    }

    @Test
    public void
    it_can_delete_any() {
        list.add(FIRST_VALUE);
        list.add(SECOND_VALUE);
        list.add(THIRD_VALUE);

        list.delete(list.find(SECOND_VALUE));

        assertThat(list.values()).isEqualTo(new String[]{FIRST_VALUE, THIRD_VALUE});
    }

    @Test
    public void
    it_can_delete_last_element() {
        list.add(FIRST_VALUE);
        list.add(SECOND_VALUE);
        list.add(THIRD_VALUE);

        list.delete(list.find(THIRD_VALUE));

        assertThat(list.values()).isEqualTo(new String[]{FIRST_VALUE, SECOND_VALUE});
    }

    private void
    acceptance_tests() {
        /*
        assert_nil(list.find("fred"));
        list.add("fred")
        assert_equal("fred", list.find("fred").value())
        assert_nil(list.find("wilma"));
        list.add("wilma");
        assert_equal("fred", list.find("fred").value());
        assert_equal("wilma", list.find("wilma").value());
        assert_equal(["fred", "wilma"],list.values());
;;
        list = List.new;
        list.add("fred")
        list.add("wilma")
        list.add("betty")
        list.add("barney")
        assert_equal(["fred", "wilma", "betty", "barney"],list.values())
        list.delete(list.find("wilma"));
        assert_equal(["fred", "betty", ";barney"],list.values())
        list.delete(list.find("barney"));;
        assert_equal(["fred", "betty"],list.values())
        list.delete(list.find("fred"));
        assert_equal(["betty"], list.values())
        list.delete(list.find("betty"))
        assert_equal([],list.values())
        */
    }


}