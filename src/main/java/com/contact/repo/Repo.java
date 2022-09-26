package com.contact.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contact.entity.Details;

public interface Repo extends JpaRepository <Details, Integer>{

}
