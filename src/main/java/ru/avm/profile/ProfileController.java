package ru.avm.profile;

import org.springframework.web.bind.annotation.*;
import ru.avm.profile.dto.ProfileDto;
import ru.avm.profile.dto.ProfileFieldDto;

import java.util.List;

@RequestMapping("default")
public interface ProfileController {

    String getAlias();

    ProfileService getProfileService();

    @GetMapping("profile")
    default ProfileDto profile() {
        return getProfileService().getProfile(getAlias()).orElseThrow();
    }

    @GetMapping("profile/fields")
    default List<ProfileFieldDto> fields() {
        return getProfileService().getProfile(getAlias())
                .map(ProfileDto::getFields)
                .orElseThrow();
    }

    @PostMapping("profile")
    default void postProfile(@RequestBody ProfileDto profile) {
        getProfileService().updateProfileFull(getAlias(), profile);
    }

    @PutMapping("profile")
    default void editProfile(@RequestBody ProfileDto profile) {
        getProfileService().updateProfile(getAlias(), profile);
    }

    @PostMapping("profile/fields")
    default void addField(@RequestBody ProfileFieldDto field) {
        getProfileService().addField(getAlias(), field);
    }

    @PutMapping("profile/fields/{name}")
    default void editField(@PathVariable String name, @RequestBody ProfileFieldDto field) {
        getProfileService().updateField(getAlias(), name, field);
    }

    @DeleteMapping("profile/fields/{name}")
    default void deleteField(@PathVariable String name) {
        getProfileService().deleteField(getAlias(), name);
    }

}
