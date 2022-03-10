package ru.avm.profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import ru.avm.profile.domain.Profile;

@Component
public interface ProfileRepository extends JpaRepository<Profile, String> {
}
