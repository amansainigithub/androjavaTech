package com.androjava.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.androjava.entity.ContactForm;

public interface ContactFormRepository extends JpaRepository<ContactForm, Long> {

}
