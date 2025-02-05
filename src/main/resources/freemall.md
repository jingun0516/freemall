```mysql
-- 회원 등급 테이블
CREATE TABLE membership
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    level      VARCHAR(255) NOT NULL UNIQUE, -- 등급 (예: Silvear, Gold, VIP 등)
    benefits   TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE users
(
    id                BIGINT AUTO_INCREMENT PRIMARY KEY,                      -- 회원 고유 ID
    login_id          VARCHAR(50) UNIQUE  NOT NULL,                           -- 로그인 ID
    name              VARCHAR(100)        NOT NULL,                           -- 전체 이름
    email             VARCHAR(100) UNIQUE NOT NULL,                           -- 이메일
    password          VARCHAR(255)        NOT NULL,                           -- 암호화된 비밀번호
    phone_number      VARCHAR(20),                                            -- 전화번호
    date_of_birth     DATE,                                                   -- 생년월일
    gender            VARCHAR(20),                                            -- 성별
    registration_date TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP, -- 가입 날짜
    last_login        TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP, -- 마지막 로그인 시간 (NULL 허용)
    deleted_at        TIMESTAMP                    DEFAULT NULL,              -- 삭제일시 (NULL이면 삭제되지 않음)
    address           VARCHAR(255)        NOT NULL,                           -- 기본 배송 주소
    membership_id     BIGINT,                                                 -- 멤버십 ID
    unique_key        VARCHAR(255),                                           -- OAUTH2 구분을 위한 key
    FOREIGN KEY (membership_id) REFERENCES membership (id)                    -- 외래키 제약 조건
);


CREATE TABLE sellers
(
    id                BIGINT AUTO_INCREMENT PRIMARY KEY,          -- 판매자 고유 ID
    user_id           BIGINT       NOT NULL UNIQUE,               -- 사용자 ID (users 테이블과 연결)
    store_name        VARCHAR(255) NOT NULL UNIQUE,               -- 상점 이름
    store_description TEXT,                                       -- 상점 설명
    registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,        -- 판매자 등록 날짜
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE -- users 테이블과 연결
);


CREATE TABLE admins
(
    id                BIGINT AUTO_INCREMENT PRIMARY KEY,          -- 어드민 고유 ID
    user_id           BIGINT       NOT NULL UNIQUE,               -- 사용자 ID (users 테이블과 연결)
    level             VARCHAR(100) NOT NULL,                      -- 어드민 등급 (슈퍼 어드민 / 어드민)
    registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,        -- 어드민 등록 날짜
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE -- users 테이블과 연결
);


CREATE TABLE manufacturers
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY, -- 제조사 고유 ID
    name        VARCHAR(255) NOT NULL UNIQUE,      -- 제조사 이름
    description TEXT                               -- 제조사 설명
);

CREATE TABLE categories
(
    id                 BIGINT AUTO_INCREMENT PRIMARY KEY,       -- 카테고리 고유 ID
    name               VARCHAR(255) NOT NULL UNIQUE,            -- 카테고리 이름
    description        TEXT,                                    -- 카테고리 설명
    parent_category_id BIGINT    DEFAULT NULL,                  -- 부모 카테고리 ID (최상위 카테고리는 NULL)
    created_at         TIMESTAMP DEFAULT CURRENT_TIMESTAMP,     -- 생성일
    FOREIGN KEY (parent_category_id) REFERENCES categories (id) -- 부모 카테고리와 연결
);

CREATE TABLE products
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,                               -- 품목 고유 ID
    name            VARCHAR(255)   NOT NULL,                                         -- 품목 이름
    description     TEXT,                                                            -- 품목 설명
    seller_id       BIGINT         NOT NULL,                                         -- 판매자 id
    price           DECIMAL(20, 4) NOT NULL,                                         -- 가격
    stock_quantity  INT            NOT NULL,                                         -- 재고 수량
    category_id     BIGINT,                                                          -- 카테고리 ID
    manufacturer_id BIGINT,                                                          -- 제조사 ID
    created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,                             -- 생성일
    updated_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 업데이트일
    FOREIGN KEY (seller_id) REFERENCES sellers (id),
    FOREIGN KEY (category_id) REFERENCES categories (id),                            -- 카테고리와 연결
    FOREIGN KEY (manufacturer_id) REFERENCES manufacturers (id)                      -- 제조사와 연결
);

CREATE TABLE product_options
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,     -- 옵션 고유 ID
    product_id BIGINT NOT NULL,                       -- 품목 ID
    attribute  VARCHAR(255),                          -- 옵션 속성 (예: 색상, 사이즈 등)
    FOREIGN KEY (product_id) REFERENCES products (id) -- 품목과 연결
);

CREATE TABLE product_option_values
(
    id                BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_option_id BIGINT NOT NULL,
    value             VARCHAR(255),
    FOREIGN KEY (product_option_id) REFERENCES product_options (id)
);

CREATE TABLE discounts
(
    id             BIGINT AUTO_INCREMENT PRIMARY KEY,               -- 할인 고유 ID
    product_id     BIGINT NOT NULL,                                 -- 품목 ID
    discount_rate  DECIMAL(5, 2),                                   -- 할인율
    discount_price DECIMAL(20, 4),                                  -- 할인 가격
    start_date     TIMESTAMP,                                       -- 시작 날짜
    end_date       TIMESTAMP,                                       -- 종료 날짜
    FOREIGN KEY (product_id) REFERENCES products (id),              -- 품목과 연결
    CHECK (discount_rate IS NOT NULL OR discount_price IS NOT NULL) -- discount_rate 또는 discount_price가 반드시 있어야 함
);

-- 결제 방법 테이블
CREATE TABLE payment_methods
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    method     VARCHAR(50) NOT NULL, -- 결제 방법 (카드, 계좌 등)
    is_active  BOOLEAN   DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


-- 결제 방법에 해당하는 제공자 목록 테이블
CREATE TABLE payment_method_providers
(
    id                BIGINT AUTO_INCREMENT PRIMARY KEY,
    payment_method_id BIGINT       NOT NULL, -- 결제 방법 ID
    provider          VARCHAR(100) NOT NULL, -- 제공자 (카드사, 은행 등)
    FOREIGN KEY (payment_method_id) REFERENCES payment_methods (id) ON DELETE CASCADE,
    UNIQUE (payment_method_id, provider)     -- 동일한 결제 방법에 중복된 제공자 없음
);

-- 회원별 결제수단 테이블
CREATE TABLE user_payment_methods
(
    id                BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id           BIGINT NOT NULL,
    payment_method_id BIGINT NOT NULL,
    created_at        TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at        TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    UNIQUE (user_id, payment_method_id),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (payment_method_id) REFERENCES payment_methods (id) ON DELETE CASCADE
);

CREATE TABLE order_history
(
    id                       BIGINT AUTO_INCREMENT PRIMARY KEY,                                    -- 주문을 고유하게 식별하는 주문 ID
    user_id                  BIGINT         NOT NULL,                                              -- 주문을 한 사용자 ID (users 테이블과 외래키 관계)
    order_date               DATETIME       NOT NULL,                                              -- 주문이 이루어진 날짜 및 시간
    order_status             VARCHAR(50)    NOT NULL,                                              -- 주문 상태 (예: "주문 완료", "배송 중", "취소" 등)
    shipping_address         TEXT           NOT NULL,                                              -- 배송지 주소
    user_payment_method_id   BIGINT         NOT NULL,                                              -- 결제 방법 ID (payment_methods 테이블과 외래키 관계)
    total_amount             DECIMAL(20, 4) NOT NULL,                                              -- 주문의 총 금액 (할인 적용 후 최종 결제 금액)
    shipping_cost            DECIMAL(20, 4) DEFAULT 0,                                             -- 배송비 (기본값 0)
    payment_status           VARCHAR(50)    NOT NULL,                                              -- 결제 상태 (예: "완료", "미결제" 등)
    tracking_number          VARCHAR(100)   DEFAULT NULL,                                          -- 배송 추적 번호 (배송 완료된 경우만 사용)
    cancellation_refund_info TEXT           DEFAULT NULL,                                          -- 취소 및 환불 정보 (취소나 환불 발생 시 사용)
    contact_info             VARCHAR(100)   NOT NULL,                                              -- 주문자 연락처 정보
    order_notes              TEXT           DEFAULT NULL,                                          -- 주문에 대한 추가 메모 (예: 배송 요청 사항 등)
    created_at               TIMESTAMP      DEFAULT CURRENT_TIMESTAMP,                             -- 생성일
    updated_at               TIMESTAMP      DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 업데이트일
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,                                 -- users 테이블과 연결
    FOREIGN KEY (user_payment_method_id) REFERENCES user_payment_methods (id)                      -- 결제 방법 테이블과 연결
);


CREATE TABLE order_items
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY, -- 주문 상세 ID
    order_id    BIGINT         NOT NULL,           -- 주문 ID (order_history 테이블과 연결)
    product_id  BIGINT         NOT NULL,           -- 상품 ID (products 테이블과 연결)
    quantity    INT            NOT NULL,           -- 주문 수량
    unit_price  DECIMAL(20, 4) NOT NULL,           -- 개별 상품 가격
    total_price DECIMAL(20, 4) NOT NULL,           -- 총 가격 (할인 적용 후 계산)
    FOREIGN KEY (order_id) REFERENCES order_history (id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES products (id)
);


-- 문의사항 테이블
CREATE TABLE inquiries
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id     BIGINT       NOT NULL,               -- 문의한 사용자 ID
    title       VARCHAR(255) NOT NULL,               -- 문의 제목
    content     TEXT         NOT NULL,               -- 문의 내용
    status      VARCHAR(255) NOT NULL,               -- 문의 상태
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 생성일
    answered_at TIMESTAMP,                           -- 응답일
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);


-- 광고 테이블
CREATE TABLE advertisement
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    seller_id  BIGINT       NOT NULL, -- 광고를 진행하는 판매자 ID
    title      VARCHAR(255) NOT NULL,
    content    TEXT         NOT NULL,
    start_date TIMESTAMP    NOT NULL,
    end_date   TIMESTAMP    NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (seller_id) REFERENCES sellers (id) ON DELETE CASCADE
);


-- 리뷰 테이블
CREATE TABLE reviews
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id    BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    rating     INT CHECK (rating >= 1 AND rating <= 5), -- 별점 (1~5)
    content    TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES products (id) ON DELETE CASCADE
);


-- 장바구니 테이블
CREATE TABLE cart
(
    id         BIGINT PRIMARY KEY,
    user_id    BIGINT UNIQUE, -- 회원 ID (1인당 하나의 장바구니)
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);


-- 장바구니 아이템 테이블
CREATE TABLE cart_items
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    cart_id    BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    quantity   INT    NOT NULL,
    added_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (cart_id) REFERENCES cart (id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES products (id)
);


-- 찜 목록 테이블 (wishlist)
CREATE TABLE wishlist
(
    user_id    BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (user_id, product_id),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES products (id) ON DELETE CASCADE
);


-- 쿠폰 테이블
CREATE TABLE coupons
(
    id             BIGINT AUTO_INCREMENT PRIMARY KEY,
    name           VARCHAR(255)       NOT NULL,
    code           VARCHAR(50) UNIQUE NOT NULL,
    description    TEXT,
    discount_rate  DECIMAL(5, 2)  DEFAULT NULL,                     -- 할인율 (예: 10.00%)
    discount_price DECIMAL(20, 4) DEFAULT NULL,                     -- 정액 할인 (예: 5000원)
    created_at     TIMESTAMP      DEFAULT CURRENT_TIMESTAMP,
    updated_at     TIMESTAMP      DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CHECK (discount_rate IS NOT NULL OR discount_price IS NOT NULL) -- discount_rate 또는 discount_price가 반드시 있어야 함
);

-- 회원별 쿠폰 테이블
CREATE TABLE user_coupons
(
    user_id   BIGINT NOT NULL,
    coupon_id BIGINT NOT NULL,
    is_used   BOOLEAN   DEFAULT FALSE, -- 사용 여부
    used_at   TIMESTAMP DEFAULT NULL,  -- 사용 일시
    PRIMARY KEY (user_id, coupon_id),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (coupon_id) REFERENCES coupons (id) ON DELETE CASCADE
);

-- 키워드 (해시태그) 테이블
CREATE TABLE keywords
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE -- 키워드명
);


-- 상품과 키워드를 연결하는 테이블
CREATE TABLE product_keywords
(
    product_id BIGINT NOT NULL,                                          -- 상품 ID
    keyword_id BIGINT NOT NULL,                                          -- 키워드 ID
    PRIMARY KEY (product_id, keyword_id),                                -- 상품과 키워드의 조합을 고유하게 설정
    FOREIGN KEY (product_id) REFERENCES products (id) ON DELETE CASCADE, -- 상품 삭제 시 연관 키워드도 삭제
    FOREIGN KEY (keyword_id) REFERENCES keywords (id) ON DELETE CASCADE  -- 키워드 삭제 시 연관 상품도 삭제
);


```