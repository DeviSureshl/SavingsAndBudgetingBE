--
-- PostgreSQL database dump
--

-- Dumped from database version 17.5
-- Dumped by pg_dump version 17.5 (Homebrew)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: uuid-ossp; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS "uuid-ossp" WITH SCHEMA public;


--
-- Name: EXTENSION "uuid-ossp"; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION "uuid-ossp" IS 'generate universally unique identifiers (UUIDs)';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: savings_accounts; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.savings_accounts (
    savings_account_number character varying(20) NOT NULL,
    user_id uuid NOT NULL,
    target_amount numeric(15,2),
    current_amount numeric(15,2),
    target_date date,
    goal_name character varying(50)
);


ALTER TABLE public.savings_accounts OWNER TO postgres;

--
-- Name: savings_transactions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.savings_transactions (
    user_id uuid NOT NULL,
    savings_account_number character varying(20) NOT NULL,
    account_number character varying(50) NOT NULL,
    transaction_amount numeric(15,2),
    transaction_id uuid DEFAULT public.uuid_generate_v4(),
    transaction_date date
);


ALTER TABLE public.savings_transactions OWNER TO postgres;

--
-- Name: transactions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.transactions (
    transaction_id uuid NOT NULL,
    user_id uuid NOT NULL,
    account_number character varying(20) NOT NULL,
    transaction_type character varying(50),
    transaction_amount numeric(15,2),
    transaction_date date
);


ALTER TABLE public.transactions OWNER TO postgres;

--
-- Name: user_accounts; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_accounts (
    account_number character varying(20) NOT NULL,
    user_id uuid NOT NULL,
    account_type character varying(50),
    balance numeric(15,2)
);


ALTER TABLE public.user_accounts OWNER TO postgres;

--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    user_id uuid NOT NULL,
    first_name character varying(255) NOT NULL,
    last_name character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    date_of_birth date NOT NULL,
    gender character(1),
    email character varying(255) NOT NULL,
    is_admin boolean
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Data for Name: savings_accounts; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.savings_accounts (savings_account_number, user_id, target_amount, current_amount, target_date, goal_name) FROM stdin;
SAV17485402645651032	80e97c6d-2d6d-40f0-b7bf-62aaae9b8c01	100000.00	50000.00	2026-11-29	Purchase house
SAV17485404222483536	5b415bb7-fee8-4fb8-bbe9-5a2e91b0876c	1500000.00	70000.00	2027-02-14	Purchase new sports car
\.


--
-- Data for Name: savings_transactions; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.savings_transactions (user_id, savings_account_number, account_number, transaction_amount, transaction_id, transaction_date) FROM stdin;
80e97c6d-2d6d-40f0-b7bf-62aaae9b8c01	SAV17485402645651032	ACC17485402345375457	30000.00	dbc88150-57c5-4d5e-bdba-4c4ded81c1a5	2025-05-29
5b415bb7-fee8-4fb8-bbe9-5a2e91b0876c	SAV17485404222483536	ACC17485403427754145	10000.00	80b24ec1-4eb0-4027-a285-6d4e67333bca	2025-05-30
\.


--
-- Data for Name: transactions; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.transactions (transaction_id, user_id, account_number, transaction_type, transaction_amount, transaction_date) FROM stdin;
6dd7ae9b-3ec8-4597-842a-b7676f11546d	80e97c6d-2d6d-40f0-b7bf-62aaae9b8c01	ACC17485402071628384	CREDIT BALANCE	150000.00	2025-05-29
b6779475-5b00-4530-8ea0-aadc763d8f12	80e97c6d-2d6d-40f0-b7bf-62aaae9b8c01	ACC17485402345375457	CREDIT BALANCE	80000.00	2025-05-29
77031d75-5cdb-48c8-abc3-5f3aa4f99f3f	80e97c6d-2d6d-40f0-b7bf-62aaae9b8c01	ACC17485402071628384	GROCERY	382.00	2025-05-29
b0d6a973-3189-4aff-8ff2-e8d428a618ef	80e97c6d-2d6d-40f0-b7bf-62aaae9b8c01	ACC17485402345375457	INVESTMENT	30000.00	2025-05-29
91f35975-73d6-4bb6-b838-82fc4f7c82f2	5b415bb7-fee8-4fb8-bbe9-5a2e91b0876c	ACC17485403427754145	CREDIT BALANCE	250000.00	2025-05-29
7ada3b0e-527e-41c8-8f12-8628ce11ece7	5b415bb7-fee8-4fb8-bbe9-5a2e91b0876c	ACC17485403596354868	CREDIT BALANCE	900000.00	2025-05-29
bdb56dd3-03c1-4f30-bd1b-4b597ed5d784	5b415bb7-fee8-4fb8-bbe9-5a2e91b0876c	ACC17485403427754145	ENTERTAINMENT	35000.00	2025-05-30
4922a79e-5141-41ff-aed4-cfcbcbe7a586	5b415bb7-fee8-4fb8-bbe9-5a2e91b0876c	ACC17485403427754145	INVESTMENT	10000.00	2025-05-30
4067a1f8-6c95-4a19-90b1-6fdccb2712cc	80e97c6d-2d6d-40f0-b7bf-62aaae9b8c01	ACC17485440301491476	CREDIT BALANCE	65000.00	2025-05-29
63febd89-5e02-4706-884b-3e2dcad8d466	33faddb6-4ecc-48fd-a1bf-594b784df01a	ACC17481006774031442	CREDIT BALANCE	25000.00	2025-05-24
0a50fa0e-6dc3-4a95-a43a-f68b71e240ac	33faddb6-4ecc-48fd-a1bf-594b784df01a	ACC17481007432665449	CREDIT BALANCE	5000.00	2025-05-24
\.


--
-- Data for Name: user_accounts; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_accounts (account_number, user_id, account_type, balance) FROM stdin;
ACC17481004844394041	33faddb6-4ecc-48fd-a1bf-594b784df01a	CURRENT	25000.00
ACC17481006774031442	33faddb6-4ecc-48fd-a1bf-594b784df01a	CURRENT	25000.00
ACC17485402071628384	80e97c6d-2d6d-40f0-b7bf-62aaae9b8c01	CURRENT	149618.00
ACC17485403427754145	5b415bb7-fee8-4fb8-bbe9-5a2e91b0876c	CURRENT	205000.00
ACC17481007432665449	33faddb6-4ecc-48fd-a1bf-594b784df01a	CHECKING	5000.00
ACC17485402345375457	80e97c6d-2d6d-40f0-b7bf-62aaae9b8c01	CHECKING	50000.00
ACC17485403596354868	5b415bb7-fee8-4fb8-bbe9-5a2e91b0876c	CHECKING	900000.00
ACC17485440301491476	80e97c6d-2d6d-40f0-b7bf-62aaae9b8c01	CHECKING	65000.00
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (user_id, first_name, last_name, password, date_of_birth, gender, email, is_admin) FROM stdin;
5b71940f-5d38-437b-a843-5155c7aacdd6	James	Smith	James@123	1981-01-02	M	JamesSmith@gmail.com	t
33faddb6-4ecc-48fd-a1bf-594b784df01a	Lisa	Mitchell	Lisa@123	1992-12-25	F	LisaMitchell@gmail.com	t
80e97c6d-2d6d-40f0-b7bf-62aaae9b8c01	Mary	Wright	Mary@123	1985-11-21	F	marywright@gmail.com	f
d8a3cf08-f830-45d3-958a-d6bfa2abac4c	Ronald	Clark	Ronald@123	1975-01-01	M	ronaldclark@gmail.com	f
0a9d6b25-dbc1-471c-9ac6-aa27307bd9c2	Lisa	Mitchell	Lisa@123	1989-09-27	F	lisamitchell@123	f
5b415bb7-fee8-4fb8-bbe9-5a2e91b0876c	David	Miller	David@123	1991-12-31	M	DavidMiller@gmail.com	f
\.


--
-- Name: savings_accounts savings_accounts_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.savings_accounts
    ADD CONSTRAINT savings_accounts_pkey PRIMARY KEY (savings_account_number);


--
-- Name: transactions transactions_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transactions
    ADD CONSTRAINT transactions_pkey PRIMARY KEY (transaction_id);


--
-- Name: user_accounts user_accounts_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_accounts
    ADD CONSTRAINT user_accounts_pkey PRIMARY KEY (account_number);


--
-- Name: users users_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key UNIQUE (email);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);


--
-- Name: savings_accounts savings_accounts_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.savings_accounts
    ADD CONSTRAINT savings_accounts_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(user_id) ON DELETE CASCADE;


--
-- Name: savings_transactions savings_transactions_account_number_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.savings_transactions
    ADD CONSTRAINT savings_transactions_account_number_fkey FOREIGN KEY (account_number) REFERENCES public.user_accounts(account_number) ON DELETE CASCADE;


--
-- Name: savings_transactions savings_transactions_savings_account_number_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.savings_transactions
    ADD CONSTRAINT savings_transactions_savings_account_number_fkey FOREIGN KEY (savings_account_number) REFERENCES public.savings_accounts(savings_account_number) ON DELETE CASCADE;


--
-- Name: savings_transactions savings_transactions_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.savings_transactions
    ADD CONSTRAINT savings_transactions_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(user_id) ON DELETE CASCADE;


--
-- Name: transactions transactions_account_number_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transactions
    ADD CONSTRAINT transactions_account_number_fkey FOREIGN KEY (account_number) REFERENCES public.user_accounts(account_number) ON DELETE CASCADE;


--
-- Name: transactions transactions_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transactions
    ADD CONSTRAINT transactions_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(user_id) ON DELETE CASCADE;


--
-- Name: user_accounts user_accounts_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_accounts
    ADD CONSTRAINT user_accounts_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(user_id) ON DELETE CASCADE;


--
-- PostgreSQL database dump complete
--

