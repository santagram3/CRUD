package com.jdbc.basic.blank.controller;

import com.jdbc.basic.blank.domain.Blank;
import com.jdbc.basic.blank.repository.BlankOracleRepo;
import com.jdbc.basic.blank.repository.BlankRepository;


import java.util.HashMap;
import java.util.Map;

public class BlankController {

    private Map<Integer, Blank> qmap = new HashMap<>();

    private BlankRepository repository;

    public BlankController() {
        this.repository = new BlankOracleRepo();
    }

    public Map<Integer,Blank> giveTable(){
        Map<Integer,Blank> table =repository.findAll();
        return table;
    }

    public String giveText(int num) {
        Blank b = repository.findOne(num);
        System.out.println(b);
        return b.getTexts();
    }




}
