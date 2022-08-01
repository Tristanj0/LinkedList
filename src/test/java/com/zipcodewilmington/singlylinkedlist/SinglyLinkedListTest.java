package com.zipcodewilmington.singlylinkedlist;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;
import static sun.nio.cs.Surrogate.is;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {

    @Test
    public void isEmptyMethod_NewListReturns_True() {
      SinglyLinkedList list = new SinglyLinkedList();

      assertTrue(list.isEmpty(), is(equalTo(true)));
    }

    @Test
    public void sizeMethod_NewListReturns_Zero() {
        SinglyLinkedList list = new SinglyLinkedList();

        assertTrue(list.size(), is(equalTo(0)));
    }

    @Test
    public void isEmptyMethod_NonEmptyList_Returns_False() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.append("some data");

        assertTrue(list.isEmpty(), is(equalTo(false)));
    }

    @Test
    public void sizeMethod_WithSingleElement_ReturnsCorrectResult() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.append("data");

        assertTrue(list.size(), is(equalTo(1)));
    }

    @Test
    public void sizeMethod_MultiplyElements_ReturnsCorrectResult() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.append("1");
        list.append("2");
        list.append("3");

        assertTrue(list.size(), is(equalTo(3)));
    }

    @Test
    public void getMethod_ListWithSingleElement_ReturnsThatElement() {
        String element = "the only element";

        SinglyLinkedList list = new SinglyLinkedList();
        list.append(element);

        assertTrue(list.get(0), is(equalTo(element)));
    }

    @Test
    public void getMethod_ListWithMultipleElements_ReturnsElement_GivenIndex() {
        String thirdElement = "third element";

        SinglyLinkedList list = new SinglyLinkedList();
        list.append("first element");
        list.append("second element");
        list.append(thirdElement);
        list.append("fourth element");

        assertTrue(list.get(2), is(equalTo(thirdElement)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getMethod_ThrowsException_ForNegativeIndex() {
        SinglyLinkedList list = new SinglyLinkedList();

        list.get(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getMethod_ThrowsException_ForIndexLargerThanSize() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.append("0");
        list.append("1");
        list.append("2");

        list.get(3);
    }

}
