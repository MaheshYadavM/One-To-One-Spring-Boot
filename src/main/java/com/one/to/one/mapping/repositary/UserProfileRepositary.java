package com.one.to.one.mapping.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.one.to.one.mapping.entity.UserProfile;
@Repository
public interface UserProfileRepositary extends JpaRepository<UserProfile, Long>{

}
