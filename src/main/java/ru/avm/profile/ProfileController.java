package ru.avm.profile;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.avm.profile.dto.ProfileDto;

@RequestMapping("default")
public interface ProfileController {

    String getAlias();

    ProfileService getProfileService();

    @GetMapping("profile")
    default ProfileDto profile(@RequestParam(required = false) String details) {
        if (details != null) {
            return getProfileService().getProfile(getAlias() + "-" + details);
        }
        return getProfileService().getProfile(getAlias());
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("profile")
    default void postProfile(@RequestBody ProfileDto profile,
                             @RequestParam(required = false) String details) {
        if (details != null) {
            postDetailsProfile(details, profile);
            return;
        }
        getProfileService().updateProfile(getAlias(), profile);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping("profile")
    default void editProfile(@RequestBody ProfileDto profile,
                             @RequestParam(required = false) String details) {
        if (details != null) {
            putDetailsProfile(details, profile);
            return;
        }
        getProfileService().updateProfile(getAlias(), profile);
    }

    @GetMapping("{name}/profile")
    default ProfileDto detailsProfile(@PathVariable String name) {
        return getProfileService().getProfile(getAlias() + "-" + name);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("{name}/profile")
    default void postDetailsProfile(@PathVariable String name, @RequestBody ProfileDto profile) {
        getProfileService().updateProfile(getAlias() + "-" + name, profile);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping("{name}/profile")
    default void putDetailsProfile(@PathVariable String name, @RequestBody ProfileDto profile) {
        getProfileService().updateProfile(getAlias() + "-" + name, profile);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("profile/{name}")
    default void postDetailsProfileAlt(@PathVariable String name, @RequestBody ProfileDto profile) {
        postDetailsProfile(name, profile);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PutMapping("profile/{name}")
    default void putDetailsProfileAlt(@PathVariable String name, @RequestBody ProfileDto profile) {
        putDetailsProfile(name, profile);
    }

}
