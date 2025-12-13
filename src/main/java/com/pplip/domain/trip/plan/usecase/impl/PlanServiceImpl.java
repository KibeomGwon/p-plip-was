package com.pplip.domain.trip.plan.usecase.impl;

import com.pplip.domain.auth.persistence.entity.Account;
import com.pplip.domain.auth.utils.SecurityUtils;
import com.pplip.domain.trip.plan.api.request.PlanRequest;
import com.pplip.domain.trip.plan.api.response.PlanResponse;
import com.pplip.domain.trip.plan.persistence.dao.PlanDao;
import com.pplip.domain.trip.plan.persistence.entity.Plan;
import com.pplip.domain.trip.plan.usecase.PlanService;
import com.pplip.global.api.code.ErrorCode;
import com.pplip.global.exception.BusinessLogicException;
import com.pplip.global.page.Page;
import com.pplip.global.page.PageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PlanServiceImpl implements PlanService {

	private final PlanDao planDao;

	@Override
	public Page<PlanResponse.Summary> getPlans(PageRequest pageRequest, UserDetails userDetails) {
		Long userId = SecurityUtils.resolveUserId(userDetails);
		List<PlanResponse.Summary> all = planDao.findAll(pageRequest, userId);
		int count = planDao.count(userId);
		return new Page<>(all, pageRequest.getPageNum(), pageRequest.getPageSize(), count);
	}

	@Override
	public PlanResponse.Detail getPlanDetail(Long id) {
		Account loginUser = SecurityUtils.getCurrentUser();
		PlanResponse.Detail detail = planDao.findByIdToDto(id).orElseThrow(() -> new BusinessLogicException(ErrorCode.PLAN_NOT_FOUND));
		if (!detail.getUserId().equals(loginUser.getUserId())) {
			throw new BusinessLogicException(ErrorCode.FORBIDDEN, "작성자만 조회 할 수 있습니다.");
		}
		return detail;
	}

	@Override
	public PlanResponse.Detail createPlan(PlanRequest.Post request, UserDetails userDetails) {
		Long userId = SecurityUtils.resolveUserId(userDetails);
		Plan plan = Plan.builder()
				.title(request.getTitle())
				.userId(userId)
				.startDate(request.getStartDate())
				.endDate(request.getEndDate())
				.createdAt(LocalDateTime.now()).build();
		planDao.insert(plan);
		return planDao.findByIdToDto(plan.getId()).orElseThrow(() -> new BusinessLogicException(ErrorCode.PLAN_NOT_FOUND, "플랜 저장에 실패했습니다."));
	}

	@Override
	public PlanResponse.Update updatePlan(PlanRequest.Update update, Long id) {
		Account currentUser = SecurityUtils.getCurrentUser();
		Plan plan = planDao.findById(id).orElseThrow(() -> new BusinessLogicException(ErrorCode.PLAN_NOT_FOUND));
		if (!currentUser.getUserId().equals(plan.getUserId())) {
			throw new BusinessLogicException(ErrorCode.FORBIDDEN, "작성자만 수정할 수 있습니다.");
		}
		plan.setTitle(update.getTitle());
		plan.setStartDate(update.getStartDate());
		plan.setEndDate(update.getEndDate());
		plan.setUpdatedAt(LocalDateTime.now());
		planDao.update(plan);
		return PlanResponse.Update.builder().id(plan.getId())
				.title(plan.getTitle())
				.startDate(plan.getStartDate())
				.endDate(plan.getEndDate())
				.updatedAt(plan.getUpdatedAt()).build();
	}

	@Override
	public PlanResponse.Remove removePlan(Long id) {
		Account currentUser = SecurityUtils.getCurrentUser();
		Plan plan = planDao.findById(id).orElseThrow(() -> new BusinessLogicException(ErrorCode.PLAN_NOT_FOUND));
		if (!plan.getUserId().equals(currentUser.getUserId())) {
			throw new BusinessLogicException(ErrorCode.FORBIDDEN, "작성자만 삭제할 수 있습니다.");
		}
		int delete = planDao.delete(id);
		if (delete < 1) {
			throw new BusinessLogicException(ErrorCode.PLAN_PROCESS_FAIL, "삭제에 실패했습니다.");
		}
		return PlanResponse.Remove.builder().id(plan.getId()).title(plan.getTitle()).build();
	}
}
