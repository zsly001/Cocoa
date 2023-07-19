package com.cocoa.algo.rec;

import lombok.Data;

public class AddDigt {

    @Data
    public static class ListNode {
        private int val;
        private ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode buildList(int[] values) {
        ListNode head = new ListNode(values[0]);
        int length = values.length;
        if(length > 1){
            ListNode tmp = head;
            for(int i=1; i<length; i++) {
                ListNode node = new ListNode(values[i]);
                tmp.setNext(node);
                tmp = node;
            }
        }
        return head;
    }

    public static ListNode add(int[] list1, int[] list2){
        ListNode a = buildList(list1);
        ListNode b = buildList(list2);
        return add0(a,b,0);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add0(l1,l2,0);
    }

    public static ListNode add0(ListNode a, ListNode b, int seed){
        if(null == a && null == b){
            if(seed==1){
                return new ListNode(1);
            }else {
                return null;
            }
        }
        int total = seed;
        int target = 0;
        int nextSeed = 0;
        ListNode nextA = null;
        ListNode nextB = null;
        if(null == a){
            total += b.val;
            nextB = b.next;
        }else if(null == b){
            total += a.val;
            nextA = a.next;
        }else {
            total += a.val + b.val;
            nextA = a.next;
            nextB = b.next;
        }
        if( total >= 10 ){
            nextSeed = 1;
            target = total - 10;
        }else {
            target = total;
        }
        ListNode newListNode = new ListNode(target);
        ListNode node = add0(nextA, nextB, nextSeed);
        newListNode.next = node;
        return newListNode;
    }

    public static void main(String[] args) {
        //int[] values = {10,20,30,40,50,60};
        int[] l1 = {9,9,9,9,9,9,9};//{2,5,3};
        int[] l2 = {9,9,9,9};//{5,5,4};
        ListNode head = add(l1,l2);
        while (null!=head){
            System.out.print(head.getVal()+",");
            head = head.getNext();
        }


    }


}
