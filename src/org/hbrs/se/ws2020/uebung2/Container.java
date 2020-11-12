package org.hbrs.se.ws2020.uebung2;

import java.util.LinkedList;

public class Container {
    LinkedList<Member> list = new LinkedList<>();


    public void addMember(Member member) throws ContainerException{

        if (!contains(member.getID())) {
            list.add(member);
        } else {

        }
    }

    private boolean contains(int id) {
        for(Member m : list){
            if (m.getID().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public String deleteMember(int id) {
        return "";
    }

    public void dump() {
        for(Member m : list){
            System.out.println(m);
        }
    }

    public int size() {
        return list.size();
    }
}
