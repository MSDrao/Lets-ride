package com.nxtwave.assignment.service;

import com.nxtwave.assignment.entity.AssetTransportationRequest;
import com.nxtwave.assignment.model.GetAllRequests;
import com.nxtwave.assignment.model.MatchingRequest;
import com.nxtwave.assignment.repository.AssetTransportationRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AssetTransportationRequestService {

    @Autowired
    AssetTransportationRequestRepository assetTransportationRequestRepository;

    public AssetTransportationRequest saveAssetTransportationRequest(AssetTransportationRequest assetTransportationRequest) {
        return assetTransportationRequestRepository.save(assetTransportationRequest);
    }

    public AssetTransportationRequest getMatchingRequest(MatchingRequest request) {
        return assetTransportationRequestRepository.findOne(request.getAssetTransportRequestId());
    }

    public Page<AssetTransportationRequest> getAllRequestsInfo(GetAllRequests requests) {
        boolean isFilterApplied = (requests.isFilterApplied() ? true : false);
        boolean isSortRequest   = (requests.isSortDateByTime() ? true : false);
        boolean isAssetFilterType = false;
        if (isFilterApplied) {
            if (requests.getFilterType().equals("status")) isAssetFilterType = true;
            else isAssetFilterType = true;
        }

        if (!isFilterApplied && !isSortRequest) {
            return assetTransportationRequestRepository.findAll(
                            new PageRequest(
                            requests.getOffset(),
                            requests.getPageSize()));
        }

        if (!isFilterApplied && isSortRequest) {
            return assetTransportationRequestRepository.findAll(
                            new PageRequest(requests.getOffset(),
                            requests.getPageSize(),
                            new Sort("startDate")));
        }

        if (isFilterApplied) {
            if (isSortRequest) {
                if (isAssetFilterType) {
            return assetTransportationRequestRepository.findByAssetType(
                            requests.getAssetTypeFilter(),
                            new PageRequest(requests.getOffset(),
                            requests.getPageSize(),
                            new Sort("startDate")));
                } else {
            return assetTransportationRequestRepository.findByStatus(
                           requests.getAssetTypeFilter(),
                           new PageRequest(requests.getOffset(),
                           requests.getPageSize(),
                           new Sort("startDate")));
                }
            } else {
                if (isAssetFilterType) {
            return assetTransportationRequestRepository.findByAssetType(
                          requests.getAssetTypeFilter(),
                          new PageRequest(requests.getOffset(),
                          requests.getPageSize()));
                } else {
            return assetTransportationRequestRepository.findByStatus(
                          requests.getAssetTypeFilter(),
                          new PageRequest(requests.getOffset(),
                          requests.getPageSize()));
                }
            }
        }
        return null;
    }
}