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
        list.add("FirstValue");
        String value = "Maxence";
        list.add(value);
        assertThat(list.find(value).value()).isEqualTo(value);
    }

    @Test
    public void
    it_can_delete() {
        //list.delete();
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