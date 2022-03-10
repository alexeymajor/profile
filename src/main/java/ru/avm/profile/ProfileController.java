package ru.avm.profile;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.avm.profile.dto.ProfileDto;

@RequestMapping("default")
public interface ProfileController {

    String getAlias();

    ProfileService getProfileService();

    @GetMapping("profile")
    default ProfileDto profile() {
        return getProfileService().getProfile(getAlias()).orElseThrow();
    }

}
