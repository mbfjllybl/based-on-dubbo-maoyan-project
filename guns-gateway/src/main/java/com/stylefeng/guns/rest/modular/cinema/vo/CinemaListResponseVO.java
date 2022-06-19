package com.stylefeng.guns.rest.modular.cinema.vo;

import com.stylefeng.guns.api.cinema.vo.CinemaVO;
import lombok.Data;

import java.util.List;

@Data
class CinemaListResponseVO {

    private List<CinemaVO> cinemas;

}
