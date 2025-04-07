package com.em.performance_service.grpc;
import com.em.performance_service.service.PerformanceService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import performance.PerformanceRequest;
import performance.PerformanceResponse;
import performance.PerformanceServiceGrpc;

import java.util.UUID;

@GrpcService
public class PerformanceGrpcService extends PerformanceServiceGrpc.PerformanceServiceImplBase {
    private static final Logger log = LoggerFactory.getLogger(PerformanceGrpcService.class);
    private final PerformanceService performanceService;

    public PerformanceGrpcService(PerformanceService performanceService) {
        this.performanceService = performanceService;
    }

    @Override
    public void createPerformanceAccount(PerformanceRequest request, StreamObserver<PerformanceResponse> responseObserver) {
        log.info("createPerformanceAccount called with request: {}", request.toString());

        performanceService.createPerformanceReview(request);

        PerformanceResponse response = PerformanceResponse.newBuilder()
                .setAccountId(request.getEmployeeId())
                .setStatus("Performance Review ACCOUNT_CREATED")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void deletePerformanceAccount(PerformanceRequest request,StreamObserver<PerformanceResponse> responseObserver) {
        log.info("deletePerformanceAccount called with request: {}", request.toString());

        performanceService.deletePerformanceReview(UUID.fromString(request.getEmployeeId()));

        PerformanceResponse response=PerformanceResponse.newBuilder()
                .setAccountId(request.getEmployeeId())
                .setStatus("Performance Review ACCOUNT_DELETED")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
