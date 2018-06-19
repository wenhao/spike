package com.github.wenhao.profile.repository;

import com.github.wenhao.profile.type.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
