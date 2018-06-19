package com.github.wenhao.profile.mapper;

import com.github.wenhao.profile.input.CreateProfileInput;
import com.github.wenhao.profile.input.UpdateProfileInput;
import com.github.wenhao.profile.type.Profile;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface ProfileMapper {

    Profile createProfileInputToProfile(CreateProfileInput input);

    Profile updateProfileInputToProfile(UpdateProfileInput input);
}
