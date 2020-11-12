package org.hbrs.se.ws2020.uebung2;

import java.util.LinkedList;

public class Container {
    private LinkedList<Member> list = new LinkedList<>();


    public void addMember(Member member) throws ContainerException{

        if (!contains(member.getID())) {
            list.add(member);
        } else {
            throw new ContainerException("Das Member-Objekt mit der ID ["+member.getID()+"] ist bereits vorhanden!");

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
        Member toDelete = null;
        for(Member m : list){
            if (m.getID().equals(id)) {
                toDelete = m;
            }
        }
        if(toDelete != null){
            list.remove(toDelete);
            return "Member (ID = ["+id+"]) deleted";
        }

        return "Member (ID = ["+id+"]) not found";

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
