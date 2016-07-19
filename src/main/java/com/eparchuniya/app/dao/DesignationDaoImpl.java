package com.eparchuniya.app.dao;

import org.springframework.stereotype.Repository;

import com.eparchuniya.app.domain.Designation;

@Repository("designationDao")
public class DesignationDaoImpl extends GenericDaoImpl<Designation, Integer> implements DesignationDao {

}
