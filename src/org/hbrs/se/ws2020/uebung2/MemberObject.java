package org.hbrs.se.ws2020.uebung2;

public class MemberObject implements Member{
    private int id;

    public MemberObject(int id){
        this.id = id;
    }
    @Override
    public Integer getID() {
        return this.id;
    }
    @Override
    public String toString(){
        return "Member (ID = ["+getID()+"])";
    }
}
