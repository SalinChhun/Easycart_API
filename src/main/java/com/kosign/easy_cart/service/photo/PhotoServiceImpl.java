package com.kosign.easy_cart.service.photo;

import com.kosign.easy_cart.entity.Photo;
import com.kosign.easy_cart.payload.photo.PhotoRequest;
import com.kosign.easy_cart.repository.PhotoRepository;
import com.kosign.easy_cart.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PhotoServiceImpl implements PhotoService{

    private final PhotoRepository photoRepository;

    @Override
    public void savePhoto(PhotoRequest photoRequest) {
        photoRepository.save(
                Photo.builder()
                        .photo(photoRequest.getPhoto())
                        .build()
        );
    }
}
